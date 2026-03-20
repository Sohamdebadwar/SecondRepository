<%@page import="Entity.User"%>
<%@page import="DBConnection.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Money</title>
    <link rel="stylesheet" href="style.css" />
    <style>
        .Moneycontainer {
            width: 400px;
            margin: 50px auto;
            background-color: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }
        h2 {
            color: #0078d7;
            text-align: center;
        }
        input[type=text], input[type=number] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        input[type=submit] {
            background-color: #0078d7;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type=submit]:hover {
            background-color: #005fa3;
        }
        .message {
            text-align: center;
            font-weight: bold;
            margin-top: 15px;
        }
        .success { color: green; }
        .error { color: red; }
        a.back {
            display: block;
            margin-top: 15px;
            text-align: center;
            text-decoration: none;
            color: #0078d7;
        }
    </style>
</head>
<body>

<header class="navbar">
    <div class="container">
        <h1 class="logo">💳 SecureBank</h1>
        <nav>
            <ul>
                <li><a href="dashboard.jsp" class="active">Dashboard</a></li>
                <li><a href="Transaction.jsp">Transactions</a></li>
                <li><a href="profile.jsp">Profile</a></li>
                <li><a href="SendMoney.jsp">Send Money</a></li>
                <li><a href="ApplyLoan.jsp">Apply Loan</a></li>
                <li><a href="logout" class="logout-btn">Logout</a></li>
            </ul>
        </nav>
    </div>
</header>


<div class="Moneycontainer">
    <h2>Send Money</h2>

    <form method="post">
        <label>Recipient Account Number or Mobile:</label>
        <input type="text" name="receiver" required placeholder="Enter account or mobile number">

        <label>Amount (₹):</label>
        <input type="number" name="amount" required min="1" step="0.01">

        <label>Description:</label>
        <input type="text" name="description" placeholder="Purpose (optional)">

        <input type="submit" value="Send Money">
    </form>

    <div class="message">
        <%
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("index.html");
                return;
            }

            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String receiver = request.getParameter("receiver");
                String description = request.getParameter("description");
                double amount = Double.parseDouble(request.getParameter("amount"));

                Connection conn = null;
                PreparedStatement psCheck = null, psUpdate = null, psTxn = null;
                ResultSet rs = null;

                try {
                    conn = DBConnection.getConnection();
                    conn.setAutoCommit(false);

                    String senderAccount = user.getAccountNumber();
                    String senderName = user.getFullName();

                    // Get sender details
                    psCheck = conn.prepareStatement("SELECT BALANCE FROM BANK_USERS WHERE ACCOUNT_NUMBER=?");
                    psCheck.setString(1, senderAccount);
                    rs = psCheck.executeQuery();

                    if (!rs.next()) {
                        out.println("<p class='error'>Sender not found!</p>");
                    } else {
                        double senderBalance = rs.getDouble("BALANCE");

                        if (senderBalance < amount) {
                            out.println("<p class='error'>Insufficient balance!</p>");
                        } else {
                            // Find receiver
                            psCheck = conn.prepareStatement("SELECT ACCOUNT_NUMBER, FULL_NAME, BALANCE FROM BANK_USERS WHERE ACCOUNT_NUMBER=? OR PHONE_NUMBER=?");
                            psCheck.setString(1, receiver);
                            psCheck.setString(2, receiver);
                            rs = psCheck.executeQuery();

                            if (!rs.next()) {
                                out.println("<p class='error'>Receiver not found!</p>");
                            } else {
                                String receiverAccount = rs.getString("ACCOUNT_NUMBER");
                                String receiverName = rs.getString("FULL_NAME");
                                double receiverBalance = rs.getDouble("BALANCE");

                                // Update sender balance
                                psUpdate = conn.prepareStatement("UPDATE BANK_USERS SET BALANCE=? WHERE ACCOUNT_NUMBER=?");
                                psUpdate.setDouble(1, senderBalance - amount);
                                psUpdate.setString(2, senderAccount);
                                psUpdate.executeUpdate();

                                // Update receiver balance
                                psUpdate.setDouble(1, receiverBalance + amount);
                                psUpdate.setString(2, receiverAccount);
                                psUpdate.executeUpdate();

                                // Record transaction in BANK_TRANSACTIONS
                                psTxn = conn.prepareStatement(
                                    "INSERT INTO BANK_TRANSACTIONS (SENDER_ACCOUNT, RECEIVER_ACCOUNT, AMOUNT, TXN_TYPE, DESCRIPTION, STATUS) VALUES (?, ?, ?, ?, ?, ?)"
                                );

                                // Sender transaction
                                psTxn.setString(1, senderAccount);
                                psTxn.setString(2, receiverAccount);
                                psTxn.setDouble(3, amount);
                                psTxn.setString(4, "TRANSFER");
                                psTxn.setString(5, (description != null && !description.isEmpty()) ? description : "Money transfer");
                                psTxn.setString(6, "SUCCESS");
                                psTxn.executeUpdate();

                                conn.commit();
                                out.println("<p class='success'>₹" + amount + " sent successfully to " + receiverName + "!</p>");
                            }
                        }
                    }

                } catch (Exception e) {
                    if (conn != null) conn.rollback();
                    out.println("<p class='error'>Transaction failed: " + e.getMessage() + "</p>");
                } finally {
                    if (rs != null) rs.close();
                    if (psCheck != null) psCheck.close();
                    if (psUpdate != null) psUpdate.close();
                    if (psTxn != null) psTxn.close();
                    if (conn != null) conn.close();
                }
            }
        %>
    </div>

    <a href="dashboard.jsp" class="back">⬅ Back to Dashboard</a>
</div>

</body>
</html>

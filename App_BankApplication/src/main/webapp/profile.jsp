<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Entity.User" %>
<%
    // Check if user is logged in
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("index.html");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Profile - SecureBank</title>
      <link rel="stylesheet" href="style.css" />
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 font-sans">

<header class="navbar">
    <div class="container">
        <h1 class="logo">💳 SecureBank</h1>
        <nav>
            <ul>
                <li><a href="dashboard.jsp">Dashboard</a></li>
                <li><a href="Transaction.jsp" class="active">Transactions</a></li>
                <li><a href="profile.jsp">Profile</a></li>
                <li><a href="SendMoney.jsp">Send Money</a></li>
                <li><a href="ApplyLoan.jsp">Apply Loan</a></li>
                <li><a href="logout" class="logout-btn">Logout</a></li>
            </ul>
        </nav>
    </div>
</header>

    <!-- Profile Section -->
    <div class="max-w-3xl mx-auto mt-10 bg-white shadow-2xl rounded-xl p-8">
        <h2 class="text-3xl font-semibold text-blue-900 mb-6 border-b-2 pb-2">👤 Your Profile</h2>

        <div class="grid grid-cols-2 gap-6 text-lg">
            <div>
                <p class="font-semibold text-gray-700">Full Name:</p>
                <p class="text-gray-800"><%= user.getFullName() %></p>
            </div>

            <div>
                <p class="font-semibold text-gray-700">Email:</p>
                <p class="text-gray-800"><%= user.getEmail() %></p>
            </div>

            <div>
                <p class="font-semibold text-gray-700">Username:</p>
                <p class="text-gray-800"><%= user.getUsername() %></p>
            </div>

            <div>
                <p class="font-semibold text-gray-700">Account Number:</p>
                <p class="text-gray-800"><%= user.getAccountNumber() %></p>
            </div>

            <div>
                <p class="font-semibold text-gray-700">Balance:</p>
                <p class="text-green-700 font-bold">₹ <%= user.getBalance() %></p>
            </div>

            <div>
                <p class="font-semibold text-gray-700">Phone Number:</p>
                <p class="text-gray-800">
                    <%=user.getPhoneNo()%>
   						
                </p>
            </div>
        </div>

        <div class="mt-8 text-center">
            <a href="dashboard.jsp" class="bg-blue-800 text-white px-6 py-2 rounded-lg hover:bg-blue-700 transition">
                🔙 Back to Dashboard
            </a>
            <a href="edit.jsp" class="bg-blue-800 text-white px-6 py-2 rounded-lg hover:bg-blue-700 transition">
               Edit
            </a>
        </div>
    </div>

</body>
</html>

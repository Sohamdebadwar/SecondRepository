<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%
    // If user is already logged in, redirect to dashboard
    HttpSession session1 = request.getSession(false);
    if (session1 != null && session1.getAttribute("user") != null) {
        response.sendRedirect("dashboard.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SecureBank | Login</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>

    <!-- Header -->
    <header>
        <div class="container">
            <h1 class="logo">💳 SecureBank</h1>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Support</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <!-- Hero Section -->
    <section class="hero">
        <div class="hero-content">
            <h2>Welcome to SecureBank</h2>
            <p>Manage your money safely and securely — anytime, anywhere.</p>
            <a href="#" class="btn">Learn More</a>
        </div>

        <!-- Login Box -->
        <div class="login-box">
            <h3>Login to Your Account</h3>
<%
               String msg = request.getParameter("msg");
    if (msg != null) {
%>
    <div style="background-color:#d4edda; color:#155724; padding:10px; border-radius:5px; text-align:center; margin:10px auto; width:50%;">
        <%= msg %>
    </div>
<%
    }
%>

            <form action="login" method="post">
                <label>Username</label>
                <input type="text" name="username" placeholder="Enter username" required />

                <label>Password</label>
                <input type="password" name="password" placeholder="Enter password" required />

                <div class="remember">
                    <label><input type="checkbox" /> Remember me</label>
                    <a href="#">Forgot Password?</a>
                </div>

                <button type="submit" class="btn-login">Login</button>

                <p class="signup">Don’t have an account? <a href="register.jsp">Register</a></p>
            </form>
        </div>
    </section>
    <!-- Footer -->
    <footer>
        <p>© 2025 SecureBank. All rights reserved.</p>
    </footer>
</body>
</html>

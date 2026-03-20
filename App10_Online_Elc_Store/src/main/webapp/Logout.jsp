<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f3f3f3;
        margin: 0;
        padding: 0;
        text-align: center;
    }

    .message-box {
        margin-top: 80px;
        display: inline-block;
        background: #ffffff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 0 15px rgba(0,0,0,0.1);
        font-size: 22px;
        color: #333;
    }

    .home-link {
        margin-top: 20px;
        display: inline-block;
        padding: 12px 25px;
        background: #007bff;
        color: #fff;
        text-decoration: none;
        border-radius: 6px;
        font-size: 18px;
        transition: 0.3s ease;
    }

    .home-link:hover {
        background: #0056b3;
    }
</style>

</head>
<body>

<div class="message-box">
    <%
        session.invalidate();
        out.println("User logged out successfully !!!");
    %>
    <br><br>

    <a class="home-link" href="index.html">Go to Home</a>
</div>

<br><br>

<!-- Optional: Keep your existing index.html content -->
<%@ include file="index.html" %>

</body>
</html>

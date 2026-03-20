<%@page import="com.pack3.CustomerBean.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Home</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f2f4f8;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 450px;
        background: #ffffff;
        margin: 80px auto;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 0 15px rgba(0,0,0,0.15);
        text-align: center;
    }

    h1 {
        margin-bottom: 20px;
        color: #333;
    }

    .btn {
        display: block;
        width: 70%;
        margin: 12px auto;
        padding: 12px;
        background: #0077ff;
        color: white;
        text-decoration: none;
        border-radius: 8px;
        font-size: 18px;
        transition: 0.3s;
    }

    .btn:hover {
        background: #005ad1;
    }

    .logout {
        background: #ff4444;
    }

    .logout:hover {
        background: #d93636;
    }
</style>

</head>
<body>

<div class="container">

    <%
        CustomerBean cb = (CustomerBean) session.getAttribute("customer");

        if(cb == null){
            response.sendRedirect("CustomerLogin.html");
            return;
        }
    %>

    <h1>Welcome <%= cb.getFname() %>!</h1>

    <a href="viewproducts" class="btn">View Products</a>
    <a href="customerlogout" class="btn logout">Logout</a>

</div>

</body>
</html>

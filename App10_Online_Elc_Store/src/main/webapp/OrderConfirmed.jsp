<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmed</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #eef2f7;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 450px;
        margin: 60px auto;
        background: #ffffff;
        padding: 30px 35px;
        border-radius: 12px;
        text-align: center;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    }

    h2 {
        color: #28a745;
        margin-bottom: 15px;
        font-size: 26px;
    }

    p {
        font-size: 18px;
        color: #333;
        margin: 10px 0;
    }

    a.btn {
        display: inline-block;
        padding: 10px 20px;
        margin: 12px;
        text-decoration: none;
        font-size: 16px;
        border-radius: 6px;
        color: white;
        transition: 0.3s;
    }

    .view-btn {
        background: #0077ff;
    }

    .view-btn:hover {
        background: #005dc0;
    }

    .logout-btn {
        background: #ff3b3b;
    }

    .logout-btn:hover {
        background: #d63232;
    }

</style>
</head>
<body>

<div class="container">

<%
String message = (String) request.getAttribute("msg");
String amount = (String) request.getAttribute("amount");
%>

<h2>Order Confirmed!</h2>

<p><%= message %></p>
<p><strong>Total Amount:</strong> <%= amount %> Rs</p>

<a class="btn view-btn" href="viewproducts">View Products</a>
<a class="btn logout-btn" href="customerlogout">Logout</a>

</div>

</body>
</html>

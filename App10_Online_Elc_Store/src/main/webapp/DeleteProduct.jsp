<%@page import="com.pack1.AdminBean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .container {
        margin-top: 80px;
        text-align: center;
    }

    h1 {
        color: #333;
        margin-bottom: 30px;
    }

    a {
        display: inline-block;
        text-decoration: none;
        padding: 12px 25px;
        margin: 10px 0;
        background: #007bff;
        color: white;
        border-radius: 6px;
        font-size: 18px;
        transition: 0.3s ease;
    }

    a:hover {
        background: #0056b3;
    }
</style>

</head>
<body>

<div class="container">
    <h1>
        <%
            AdminBean abean = (AdminBean) session.getAttribute("AdminBean");
            String data = (String) request.getAttribute("msg");
            out.println("Hello " + abean.getA_fname() + "<br><br>");
            out.println(data + "<br><br>");
        %>

        <a href="AddProduct.html">Add Product</a> <br>
        <a href="view1">View Product</a> <br>
        <a href="logout">Logout</a>
    </h1>
</div>

</body>
</html>

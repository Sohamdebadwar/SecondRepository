<%@page import="com.pack1.AdminBean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<style>
    body {
        font-family: "Segoe UI", Arial, sans-serif;
        background: linear-gradient(to right, #e3f2fd, #f8f9fa);
        margin: 0;
        padding: 0;
    }

    h1 {
        background-color: #1976d2;
        color: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.2);
        width: 400px;
        text-align: center;
    }

    a {
        display: inline-block;
        text-decoration: none;
        background-color: #1976d2;
        color: white;
        padding: 10px 25px;
        border-radius: 6px;
        font-weight: bold;
        margin: 10px 0;
        transition: 0.3s;
    }

    a:hover {
        background-color: #0d47a1;
        transform: scale(1.05);
    }

    input[type="button"] {
        background-color: #e53935;
        color: white;
        border: none;
        padding: 10px 25px;
        border-radius: 6px;
        cursor: pointer;
        font-weight: bold;
        transition: 0.3s;
    }

    input[type="button"]:hover {
        background-color: #b71c1c;
        transform: scale(1.05);
    }

    center {
        margin-top: 80px;
    }
</style>

</head>
<body>
<center>
    <h1>
        <%
            AdminBean abean = (AdminBean)session.getAttribute("AdminBean");
            String data = (String) request.getAttribute("msg");
            out.println(data + " Mr. " + abean.getA_fname() + "<br><br>");
        %>
        <a href="AddProduct.html">Add Product</a> <br><br>
        <a href="view1">View Product</a> <br><br>
        <a href="logout"><input type="button" value="Logout"></a>
    </h1>
</center>
</body>
</html>

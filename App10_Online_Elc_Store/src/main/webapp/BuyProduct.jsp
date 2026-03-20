<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Product</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #eef2f7;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 450px;
        background: #ffffff;
        margin: 50px auto;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    }

    h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #333;
    }

    .label {
        font-size: 17px;
        color: #555;
        font-weight: bold;
    }

    .value {
        font-size: 17px;
        color: #222;
        margin-bottom: 15px;
        display: block;
    }

    input[type="text"] {
        width: 95%;
        padding: 10px;
        margin: 10px 0 20px 0;
        border: 1px solid #ccc;
        border-radius: 6px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 12px;
        background: #0077ff;
        color: #fff;
        font-size: 18px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background: #005dc0;
    }
</style>

</head>
<body>

<%
ResultSet rs = (ResultSet) request.getAttribute("productData");
rs.next();


%>

<div class="container">

<h2>Buy Product</h2>

<form action="updateproduct" method="post">

    <span class="label">PCode:</span>
    <input type="text" name="pcode" value="<%= rs.getString(1) %>" readonly>

    <span class="label">Name:</span>
    <span class="value"><%= rs.getString(2) %></span>

    <span class="label">Company:</span>
    <span class="value"><%= rs.getString(3) %></span>

    <span class="label">Price:</span>
    <span class="value"><%= rs.getString(4) %></span>

    <span class="label">Available Qty:</span>
    <span class="value"><%= rs.getString(5) %></span>

    <span class="label">Enter Quantity:</span>
    <input type="text" name="reqqty" placeholder="Enter quantity to buy">

    <input type="submit" value="Buy">

</form>

</div>

</body>
</html>

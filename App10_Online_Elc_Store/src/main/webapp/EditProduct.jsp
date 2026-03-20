<%@page import="com.pack2.ProductBean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pack1.AdminBean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .container {
        margin-top: 70px;
        text-align: center;
    }

    h1 {
        color: #333;
        margin-bottom: 20px;
        font-size: 28px;
    }

    form {
        display: inline-block;
        background: #fff;
        padding: 25px 40px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        text-align: left;
    }

    label {
        font-size: 18px;
        color: #333;
    }

    input[type="text"] {
        width: 250px;
        padding: 8px;
        font-size: 16px;
        margin-bottom: 15px;
        border: 1px solid #bbb;
        border-radius: 4px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        font-size: 18px;
        background: #007bff;
        color: white;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: 0.3s ease;
    }

    input[type="submit"]:hover {
        background: #0056b3;
    }
</style>

</head>
<body>

<div class="container">
    <h1>
        <%
            AdminBean abean = (AdminBean) session.getAttribute("AdminBean");
            ProductBean pb = (ProductBean) request.getAttribute("pbitem");
            out.println("Hello " + abean.getA_fname() + ", please edit:<br><br>");
        %>
    </h1>

    <form action="update" method="post">
        <label>Product Price :</label><br>
        <input type="text" name="pprice" value="<%= pb.getP_price() %>"><br>

        <label>Product Quantity :</label><br>
        <input type="text" name="pqty" value="<%= pb.getP_qty() %>"><br>

        <input type="hidden" name="pcode" value="<%= pb.getP_code() %>">

        <input type="submit" value="Update">
    </form>
</div>

</body>
</html>

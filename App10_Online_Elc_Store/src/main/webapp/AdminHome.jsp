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
        font-family: 'Segoe UI', Arial, sans-serif;
        background: linear-gradient(to right, #e3f2fd, #f8f9fa);
        margin: 0;
        padding: 0;
    }

    .container {
        margin-top: 100px;
        background-color: #ffffff;
        padding: 40px;
        border-radius: 15px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        width: 400px;
        text-align: center;
    }

    h1 {
        color: #0d47a1;
        margin-bottom: 30px;
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
        transition: all 0.3s ease;
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
        font-weight: bold;
        cursor: pointer;
        transition: all 0.3s ease;
    }

    input[type="button"]:hover {
        background-color: #b71c1c;
        transform: scale(1.05);
    }
</style>

</head>
<body>
    <center>
        <div class="container">
            <h1>
                <%
                    AdminBean abean = (AdminBean)session.getAttribute("AdminBean");
                    out.println("Welcome Mr/Ms. " + abean.getA_fname() + "<br><br>");
                %>
            </h1>
            
            <form action="logout" method="post">
                <a href="AddProduct.html">Add Product</a> <br><br>
                <a href="view1">View Product</a> <br><br>
                <a href="logout">
                    <input type="button" value="Logout">
                </a>
            </form>
        </div>
    </center>
</body>
</html>

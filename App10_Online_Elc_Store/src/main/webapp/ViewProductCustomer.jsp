<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Products List</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #eef2f7;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 900px;
        margin: 40px auto;
        background: #fff;
        padding: 25px 35px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 25px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 25px;
    }

    table th {
        background: #0077ff;
        color: white;
        padding: 12px;
        font-size: 17px;
        border-radius: 4px 4px 0 0;
    }

    table td {
        padding: 12px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    table tr:hover {
        background: #f1f6ff;
        transition: 0.3s;
    }

    a.buy-btn {
        background: #28a745;
        color: white;
        padding: 7px 12px;
        text-decoration: none;
        border-radius: 4px;
        font-size: 15px;
    }

    a.buy-btn:hover {
        background: #1e7e34;
    }

    .logout-btn {
        text-decoration: none;
        background: #ff3b3b;
        padding: 10px 20px;
        border-radius: 6px;
        color: white;
        font-size: 16px;
        display: inline-block;
        transition: 0.3s;
    }

    .logout-btn:hover {
        background: #d63030;
    }
</style>

</head>
<body>

<div class="container">
<h2>Products List</h2>

<table>
<tr>
   <th>PCode</th>
   <th>Name</th>
   <th>Company</th>
   <th>Price</th>
   <th>Qty</th>
   <th>Buy</th>
</tr>

<%
ResultSet rs = (ResultSet) request.getAttribute("productData");
while(rs.next()){
%>

<tr>
   <td><%= rs.getString(1) %></td>
   <td><%= rs.getString(2) %></td>
   <td><%= rs.getString(3) %></td>
   <td><%= rs.getString(4) %></td>
   <td><%= rs.getString(5) %></td>

   <td>
      <a class="buy-btn" href="buyproduct?pcode=<%= rs.getString(1) %>">Buy</a>
   </td>
</tr>

<%
}
%>
</table>

<center>
<a class="logout-btn" href="customerlogout">Logout</a>
</center>

</div>

</body>
</html>

<%@page import="java.util.Iterator"%>
<%@page import="com.pack2.ProductBean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pack1.AdminBean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f4f4;
        margin: 0;
        padding: 0;
        text-align: center;
    }

    h1 {
        margin-top: 40px;
        font-size: 32px;
        color: #333;
    }

    table {
        margin-top: 30px;
        border-collapse: collapse;
        width: 85%;
        background: #fff;
        margin-left: auto;
        margin-right: auto;
        box-shadow: 0 0 15px rgba(0,0,0,0.1);
    }

    th, td {
        padding: 12px 15px;
        border-bottom: 1px solid #ddd;
        font-size: 18px;
    }

    th {
        background: #007bff;
        color: white;
    }

    tr:hover {
        background: #f1f1f1;
    }

    a.btn {
        padding: 6px 15px;
        text-decoration: none;
        color: white;
        border-radius: 5px;
        font-size: 16px;
        margin: 0 5px;
    }

    .edit {
        background: #28a745;
    }

    .edit:hover {
        background: #1f7a33;
    }

    .delete {
        background: #dc3545;
    }

    .delete:hover {
        background: #a71d2a;
    }

    .empty-msg {
        font-size: 24px;
        margin-top: 50px;
        color: #555;
    }
</style>

</head>
<body>

<%
    AdminBean abean =(AdminBean)session.getAttribute("AdminBean");
    ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("ProductList");
%>

<h1>Hello <%= abean.getA_fname() %>, these are your product details</h1>

<%
    if (al.size() == 0) {
%>

    <div class="empty-msg">Product Inventory is Empty</div>

<%
    } else {
%>

<table>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Company</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Actions</th>
    </tr>

    <%
        Iterator<ProductBean> it = al.iterator();
        while(it.hasNext()) {
            ProductBean pb = it.next();
    %>

    <tr>
        <td><%= pb.getP_code() %></td>
        <td><%= pb.getP_name() %></td>
        <td><%= pb.getP_company() %></td>
        <td><%= pb.getP_price() %></td>
        <td><%= pb.getP_qty() %></td>
        <td>
            <a class="btn edit" href="edit?pcode=<%= pb.getP_code() %>">Edit</a>
            <a class="btn delete" href="delete?pcode=<%= pb.getP_code() %>">Delete</a>
        </td>
    </tr>

    <% } %>

</table>

<%
    }
%>

</body>
</html>

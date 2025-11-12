<%@page import="com.pack1.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>
		<%
		UserBean ub = (UserBean)application.getAttribute("UserBean");
		out.println("Welcome :"+ub.getuFname()+"!!! <br><br>");
		%>
		
		<a href="view">View Profile</a> <br><br>
		<a href="edit">Edit Profile</a> <br><br>
		<a href="logout">Logout</a> <br><br>
	</h1>

	
</body>
</html>
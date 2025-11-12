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
				String data = (String) request.getAttribute("msg");
				String fn = (String) request.getAttribute("fname");
				UserBean ub = (UserBean)application.getAttribute("UserBean");
				
				out.println("This Session Belongs to "+fn);
				out.println(data+"<br><br>");
				
			%>
			
			<a href="view">View Profile</a> <br><br>
			<a href="logout">Logout</a> <br><br>
		</h1>
</body>
</html>
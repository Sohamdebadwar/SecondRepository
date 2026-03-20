<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.pac1.UserBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>
		<jsp:useBean id="ub" class="com.pac1.UserBean"  scope="session"></jsp:useBean>
		<jsp:setProperty property="userName" param="uname" name="ub"/>
		<jsp:setProperty property="userMail" param="umid" name="ub"/>
		<jsp:setProperty property="userMob" param="umob" name="ub"/>
		
		Details Added to Bean Successfully!!! <br><br>
		
		<a href="View.jsp">View Details</a>
	</h1>
</body>
</html>
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
		User Name : <jsp:getProperty property="userName" name="ub"/> <br><br>
		Mail Id : <jsp:getProperty property="userMail" name="ub"/> <br><br>
		Mobile Number : <jsp:getProperty property="userMob" name="ub"/> <br><br>
	</h1>
</body>
</html>
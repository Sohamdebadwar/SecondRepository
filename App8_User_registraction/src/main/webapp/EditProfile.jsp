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
					UserBean ub = (UserBean) application.getAttribute("UserBean");
					String fn = (String)request.getAttribute("fname");
					out.println("This session belongs to "+fn+"<br><br>");
			%>
			
			<form action="update" method="post">
				First Name : <input type="text" name="fname" value="<%=ub.getuFname()%>"><br><br>
				Last Name : <input type="text" name="lname" value="<%=ub.getuLname()%>"><br><br>
				Mail Id : <input type="text" name="mail" value="<%=ub.getuMail()%>"><br><br>
				Phone : <input type="text" name="phone" value="<%=ub.getuPhon()%>"><br><br>
				<input type="submit" value="Update">
			</form>
</body>
</html>
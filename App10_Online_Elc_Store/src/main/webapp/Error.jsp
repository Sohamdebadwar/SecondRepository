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
			String msg = (String) request.getAttribute("msg");
			//out.println(msg);
   			//response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);  //405
			response.sendError(405,msg);  //405
		%>
		<%= msg %>	<br><br> 
		
		  <a href="AddProduct.html">Add Product</a> <br><br>
          <a href="view1">View Product</a> <br><br>
          <a href="logout">Logout </a>
	</h1>

</body>
</html>
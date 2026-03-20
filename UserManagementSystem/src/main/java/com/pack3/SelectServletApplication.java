package com.pack3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack2.DBConnectionProvider;

@WebServlet("/view")
public class SelectServletApplication extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
			res.setContentType("text/html");
	        PrintWriter out = res.getWriter();
	
	        try
	        {
	        		Connection con = DBConnectionProvider.connect();
	        		PreparedStatement pstmt = con.prepareStatement("select * from empdata");
	        		ResultSet rs = pstmt.executeQuery();
	        
	        out.println("<html>");
	        out.println("<body style='background-color:lightyellow;'>");
	        out.println("<center><h2>Employee Details Table</h2>");
	        out.println("<table border='2' cellpadding='10'>");
	        out.println("<tr><th>Eid</th><th>Ename</th><th>EaadharNumber</th></tr>");
	        while(rs.next())
	        {
	        out.println("<tr>");

	        out.println("<td>" + rs.getString(1) + "</td>");
	        out.println("<td>" + rs.getString(2) + "</td>");
	        out.println("<td>" + rs.getString(3) + "</td>");
	        }
	        out.println("</tr></table><br><br><br>");
	        out.println("<a href='index.html'>back</a>");
	        out.println("</center></body></html>"); 
	        }
	        
	      
	        catch(Exception e)
	        {
	        		e.printStackTrace();
	        		
	        }
	
	}

}

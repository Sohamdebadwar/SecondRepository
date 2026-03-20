package com.pack3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack1.EmployeeBean;
import com.pack2.DBConnectionProvider;

/*

SQL> create table empdata (eid varchar2(5) primary key,ename varchar2(30),eadharnumber varchar2(12));

Table created.
 */

@WebServlet("/insertDataServlet")
public class InsertServletApplication extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		EmployeeBean bean = new EmployeeBean();
		
		bean.setId(req.getParameter("eid"));
		bean.setName(req.getParameter("ename"));
		bean.setAdharNo(req.getParameter("eaadhar"));
		
		
		try
		{
			
			Connection con = DBConnectionProvider.connect();
			PreparedStatement pstmt = con.prepareStatement("insert into empdata values (?,?,?)");
			pstmt.setString(1,bean.getId());
			pstmt.setString(2,bean.getName());
			pstmt.setString(3,bean.getAdharNo());
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount ==0)
			{
				pw.print("<center>Data Not Inserted</center>");
			}
			else
			{
				pw.print("<center><h1>Data Inserted</h1></center>");
				RequestDispatcher rd = req.getRequestDispatcher("index.html");
				rd.include(req, res);
			}
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
}

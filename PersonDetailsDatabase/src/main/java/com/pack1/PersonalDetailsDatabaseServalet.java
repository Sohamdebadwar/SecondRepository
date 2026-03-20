package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
public class PersonalDetailsDatabaseServalet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

      
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");
        
       if(age > 100)
       {
    	   	out.println("<h1 style='color:red'>Age Should be less than 100 !!!</h1>");
       }

        try 
		{
        		Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","soham","123");
			PreparedStatement pstmt = con.prepareStatement("insert into personaldetails values (?,?,?,?)");
			pstmt.setString(1,name);
			pstmt.setInt(2,age);
			pstmt.setString(3,mobile);
			pstmt.setString(4,gender);
			
			int rowCount = pstmt.executeUpdate();
			if(rowCount == 0)
			{
				out.println("<h1 style='color:red'>Record Not Submitted Successfully !!!</h1>");
				throw new RuntimeException("Data not inserted!!!");
			}
			else
			{
				System.out.println("data inserted");
				out.println("<h1 style='color:green'>Record Submitted Successfully !!!</h1>");	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        
    }
}

/*
 * SQL> CREATE TABLE personaldetails (
  2    name VARCHAR2(30) not null,
  3    age NUMBER(3) NOT NULL CHECK (age BETWEEN 1 AND 100),
  4    mobileno VARCHAR2(10) NOT NULL CHECK (REGEXP_LIKE(mobileno, '^[0-9]{10}$')),
  5    gender VARCHAR2(20) CHECK (gender IN ('male', 'female'))
  6  );

Table created.
*/

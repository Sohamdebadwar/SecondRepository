package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ve")
public class VotingEligibiltyServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age")) ;
		String add = req.getParameter("add");
		String city = req.getParameter("city");
		String country = req.getParameter("country").toUpperCase();
		
		pw.println("<center><h1>");
		pw.println("Name : "+name +"</br>");
		pw.println("Age : "+age +"</br>");
		pw.println("Address : "+add+"</br>");
		pw.println("City : "+city+"</br>");
		pw.println("Country : "+country+"</br>");
		if(age > 18 && country.equals("INDIA"))
		{
			pw.println(name+" is Eligible For Voting"+"<br>");
		}
		else
		{
			pw.println(name+" is Not Eligible For Voting."+"<br>");
			pw.println(age+" age is Must be greater than 18+ !!!"+"<br>");
		}
		pw.println("</center></h1>");
	}
}

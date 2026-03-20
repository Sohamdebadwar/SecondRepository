package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/vs")
public class ValidateServalet implements Servlet 
{

	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
			String name = req.getParameter("name");
			String pass = req.getParameter("pass");
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			if(name.equals("soham") && pass.equals("123")) 
			{
				pw.println("Welcome User !!!!");
			}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("/wr");
				rd.forward(req, res);
			}
	}

}

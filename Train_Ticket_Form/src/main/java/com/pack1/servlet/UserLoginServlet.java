package com.pack1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack1.DAO.UserLoginDAO;
import com.pack1.UserBean.UserBean;


@WebServlet("/login")
public class UserLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		UserLoginDAO DAOobj = new UserLoginDAO();
		UserBean ub = DAOobj.chaeckLogin(req.getParameter("uname"), req.getParameter("upwd"));
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if(ub == null)
		{
			pw.print("<center><h1>Invalid User Credentials !!!</center></h1>");
			req.getRequestDispatcher("index.html").include(req, res);;
		}
		else
		{
			req.getRequestDispatcher("TicketForm.html").forward(req, res);
			
		}
		
	}	
}
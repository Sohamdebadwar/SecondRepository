package com.pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		UserLoginDAO DAOobj = new UserLoginDAO();
		UserBean ub = DAOobj.chaeckLogin(req.getParameter("uname"), req.getParameter("upwd"));
		
		if(ub == null)
		{
			req.setAttribute("msg","Invalid User Credentials");
			req.getRequestDispatcher("Register.jsp").forward(req, res);;
		}
		else
		{
			ServletContext context = req.getServletContext();
			context.setAttribute("UserBean", ub);
			Cookie c = new Cookie("ck1",ub.getuName());
			res.addCookie(c);
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		
	}	
}

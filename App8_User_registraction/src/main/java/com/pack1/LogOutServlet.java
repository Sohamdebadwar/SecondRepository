package com.pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Cookie[] cookies = req.getCookies();
		if(cookies == null)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Register,jsp").forward(req, resp);
		}
		else
		{
			ServletContext context = req.getServletContext();
			context.removeAttribute("UserBean");
			cookies[0].setMaxAge(0);
			resp.addCookie(cookies[0]);
			req.setAttribute("msg","User Logged out successfully !!!");
			req.getRequestDispatcher("Register.jsp").forward(req, resp);
		}
	}
}

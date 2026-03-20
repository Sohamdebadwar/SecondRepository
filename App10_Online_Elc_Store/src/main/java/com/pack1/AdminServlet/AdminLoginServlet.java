package com.pack1.AdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack1.AdminBean.AdminBean;
import com.pack1.AdminDAO.AdminLoginDAO;

@WebServlet("/alogin")
public class AdminLoginServlet extends HttpServlet 
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		AdminBean abean = new AdminLoginDAO().checkAdminLogin(req.getParameter("aname"), req.getParameter("apwd"));
		
		if(abean == null)
		{
			req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
		}
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("AdminBean", abean);
			req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
	
		}
	}
}

package com.pack3.CustomerServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/customerlogout")
public class CustomerLogoutServlet extends HttpServlet 
{

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
    	
    		HttpSession session = req.getSession(false);
		if(session == null)
		{
			req.getRequestDispatcher("AdminLogin.html").forward(req, res);
		}
		else
		{
			req.getRequestDispatcher("Logout.jsp").forward(req, res);
		}
    }
}

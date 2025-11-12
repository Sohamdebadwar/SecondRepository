package com.pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Cookie[] cookies = req.getCookies();
		String fname = null;
		
		if(cookies == null)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Register.jsp").forward(req, resp);
		}
		else
		{
			ServletContext context = req.getServletContext();
			UserBean ub =(UserBean)context.getAttribute("UserBean");
			
			ub.setuFname(req.getParameter("fname"));
			ub.setuLname(req.getParameter("lname"));
			ub.setuMail(req.getParameter("mail"));
			ub.setuPnno(req.getParameter("phone"));
			
			int rowCount = new UpdateProfileDAO().UpdateData(ub);
			if(rowCount > 0)
			{
				req.setAttribute("msg","Profile Updated");
				for(Cookie c: cookies)
				{
					if("ck1".equals(c.getName()))
					{
						fname = c.getValue();
						req.setAttribute("fname",fname);
						req.getRequestDispatcher("UpdateProfile.jsp").forward(req, resp);
					}
				}
			}
			else
			{
				throw new RuntimeException("Technical Error");
			}
		}
	}
}

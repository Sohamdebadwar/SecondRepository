package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class UserRegistractionServlet extends HttpServlet
{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException 
	{
		UserBean bean = new UserBean();
		bean.setuName(req.getParameter("uname"));
		bean.setuPwd(req.getParameter("upwd"));
		bean.setuFname(req.getParameter("ufname"));
		bean.setuLname(req.getParameter("ulname"));
		bean.setuMail(req.getParameter("umail"));
		bean.setuPnno(req.getParameter("uphone"));
		
		int rowCount = new UserRegisterDao().insertRecord(bean);
		
		if(rowCount == 0)
		{
			req.setAttribute("msg","Data Not Inserted");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("msg","Data inserted in the DataBase");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		
	}
}

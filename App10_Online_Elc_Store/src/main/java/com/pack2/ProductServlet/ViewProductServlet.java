package com.pack2.ProductServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack2.ProductBean.ProductBean;
import com.pack2.ProductDAO.ViewProductDAO;

@WebServlet("/view1")
public class ViewProductServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
		}
		else
		{
			ArrayList<ProductBean> al = new ViewProductDAO().viewProducts();
			session.setAttribute("ProductList", al);
			req.getRequestDispatcher("ViewProduct.jsp").forward(req, resp);
		}
	}
}

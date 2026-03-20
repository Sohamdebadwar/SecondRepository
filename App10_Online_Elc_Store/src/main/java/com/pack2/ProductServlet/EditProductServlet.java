package com.pack2.ProductServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack2.ProductBean.ProductBean;

@WebServlet("/edit")
public class EditProductServlet extends HttpServlet 
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
			String pcode = req.getParameter("pcode");
			ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("ProductList");
			Iterator<ProductBean> i = al.iterator();
			ProductBean pb = null;
			
			while(i.hasNext())
			{
				pb= i.next();
				if(pcode.equals(pb.getP_code()))
				{
					break;
				}
			}
			req.setAttribute("pbitem", pb);
			req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
			
		}
	}
}

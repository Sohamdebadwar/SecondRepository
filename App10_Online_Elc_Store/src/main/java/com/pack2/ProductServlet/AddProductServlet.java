package com.pack2.ProductServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack2.ProductBean.ProductBean;
import com.pack2.ProductDAO.AddProductDAO;

@WebServlet("/aps")
public class AddProductServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
		}
		else
		{
			ProductBean pb = new ProductBean();
			pb.setP_code(req.getParameter("pcode"));
			pb.setP_name(req.getParameter("pname"));
			pb.setP_company(req.getParameter("pcompany"));
			pb.setP_price(req.getParameter("pprice"));
			pb.setP_qty(req.getParameter("pqty"));
	
			int rowCount = new AddProductDAO().insertProduct(pb);
			if(rowCount >0)
			{
				req.setAttribute("msg", "Products added to the Inventory");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);
			}
			else
			{
				throw new RuntimeException("Product Inventory Not Updated");
			}	
		}
	}
}






/*
@WebServlet("/aps")
public class AddProductServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try 
		{
			HttpSession session = req.getSession(false);
			if(session == null)
			{
				req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
			}
			else
			{
				ProductBean pb = new ProductBean();
				pb.setP_code(req.getParameter("pcode"));
				pb.setP_name(req.getParameter("pname"));
				pb.setP_company(req.getParameter("pcompany"));
				pb.setP_price(req.getParameter("pprice"));
				pb.setP_qty(req.getParameter("pqty"));
				
				int rowCount = new AddProductDAO().insertProduct(pb);
				if(rowCount >0)
				{
					req.setAttribute("msg", "Products added to the Inventory");
					req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);
					
				}
				
//				else
//				{
//					throw new RuntimeException("Product Inventory Not Updated");
//					
//				}
				
			}
		} 
		catch (Exception e) 
		{
			req.setAttribute("msg", "Duplicate Product Id's are not allowed !!!");
			req.getRequestDispatcher("Error.jsp").forward(req, resp);
		}
	}

}
*/
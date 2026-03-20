package com.pack2.ProductServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack2.ProductDAO.DeleteProductDAO;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet 
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
			int rowCount = new DeleteProductDAO().deleteProduct(pcode);
			
			if(rowCount > 0)
			{
				req.setAttribute("msg","Product Deleted !!!");
				req.getRequestDispatcher("DeleteProduct.jsp").forward(req, resp);
			}
			else
			{
				throw new RuntimeException("Product Deleted Failed");
			}
		}
	}

}

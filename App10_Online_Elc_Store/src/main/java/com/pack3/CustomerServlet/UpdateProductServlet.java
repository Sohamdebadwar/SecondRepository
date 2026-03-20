package com.pack3.CustomerServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack1.conn.DBConnect;
import com.pack3.CustomerDAO.UpdateProductServletDAO;

@WebServlet("/updateproduct")
public class UpdateProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {

	    String pcode = req.getParameter("pcode");
	    int reqQty = Integer.parseInt(req.getParameter("reqqty"));

	   
	    if (reqQty <= 0) {
	        req.setAttribute("msg", "Invalid quantity! Please enter value greater than 0.");
	        req.setAttribute("amount", "0");
	        RequestDispatcher rd = req.getRequestDispatcher("OrderConfirmed.jsp");
	        rd.forward(req, res);
	        return;
	    }

	    Connection con = DBConnect.connect();

	    try {
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT PPRICE, PQTY FROM PRODUCT1 WHERE PCODE=?"
	        );
	        ps.setString(1, pcode);

	        ResultSet rs = ps.executeQuery();
	        rs.next();

	        int price = Integer.parseInt(rs.getString("PPRICE"));
	        int qty = Integer.parseInt(rs.getString("PQTY"));

	       
	        if (reqQty > qty) {
	            req.setAttribute("msg", "Not enough stock available!");
	            req.setAttribute("amount", "0");
	            RequestDispatcher rd = req.getRequestDispatcher("OrderConfirmed.jsp");
	            rd.forward(req, res);
	            return;
	        }

	        // Correct stock update
	        int finalQty = qty - reqQty;
	        int total = price * reqQty;

	        UpdateProductServletDAO dao = new UpdateProductServletDAO();
	        dao.updateQty(pcode, finalQty);

	        req.setAttribute("msg", "Your Order is placed Successfully!");
	        req.setAttribute("amount", String.valueOf(total));

	        RequestDispatcher rd = req.getRequestDispatcher("OrderConfirmed.jsp");
	        rd.forward(req, res);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}

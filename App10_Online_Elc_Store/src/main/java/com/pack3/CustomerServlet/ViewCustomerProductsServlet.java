package com.pack3.CustomerServlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack3.CustomerDAO.ViewCustomerProductDAO;

@WebServlet("/viewproducts")
public class ViewCustomerProductsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("customer") == null) {
         //   res.sendRedirect("CustomerLogin.html");
            req.getRequestDispatcher("CustomerLogin.html");
            return;
        }

   
        ResultSet rs =  new ViewCustomerProductDAO().getProducts();

        req.setAttribute("productData", rs);
        req.getRequestDispatcher("ViewProductCustomer.jsp").forward(req, res);;
        
    }
}

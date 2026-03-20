package com.pack3.CustomerServlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack3.CustomerDAO.BuyProductServletDAO;

@WebServlet("/buyproduct")
public class BuyProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String pcode = req.getParameter("pcode");

        BuyProductServletDAO dao = new BuyProductServletDAO();
        ResultSet rs = dao.getProduct(pcode);

        req.setAttribute("productData", rs);
        RequestDispatcher rd = req.getRequestDispatcher("BuyProduct.jsp");
        rd.forward(req, res);
    }
}

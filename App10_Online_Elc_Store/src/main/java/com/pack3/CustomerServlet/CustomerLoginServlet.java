package com.pack3.CustomerServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack3.CustomerBean.CustomerBean;
import com.pack3.CustomerDAO.CustomerLoginDAO;

@WebServlet("/customerlogin")
public class CustomerLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	
    	 PrintWriter pw = res.getWriter();
         res.setContentType("text/html");

        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        CustomerLoginDAO dao = new CustomerLoginDAO();
        CustomerBean cb = dao.validate(uname, pwd);
        
        

        if (cb != null) {
            HttpSession session = req.getSession();
            session.setAttribute("customer", cb);
            req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
        //    res.sendRedirect("CustomerHome.jsp");
        } else 
        {	
            pw.println("<h1><center>");
            pw.println("Invalid Login");
         //   pw.println("<a href='CustomerLogin.html'>Try Again !!!</a>");
               pw.println("Try Again !!!</a>");
               pw.println("</h1></center>");
            req.getRequestDispatcher("CustomerLogin.html").include(req, res);
        }
    }
}

package com.pack3.CustomerServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack3.CustomerBean.CustomerBean;
import com.pack3.CustomerDAO.CustomerRegisterDAO;

@WebServlet("/customerregister")
public class CustomerRegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        CustomerBean cb = new CustomerBean();
        cb.setUname(req.getParameter("uname"));
        cb.setPwd(req.getParameter("pwd"));
        cb.setFname(req.getParameter("fname"));
        cb.setLname(req.getParameter("lname"));
        cb.setAddress(req.getParameter("addr"));
        cb.setMail(req.getParameter("mid"));
        cb.setMobile(req.getParameter("phno"));

     int rowCount =  new CustomerRegisterDAO().register(cb);
       

        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        pw.println("<h1><center>");
        if (rowCount > 0) {
            pw.println("Registration Successful");
            req.getRequestDispatcher("CustomerLogin.html").include(req, res);
     //       pw.println("<a href='CustomerLogin.html'>Login Now</a>");
        } else {
            pw.println("Registration Failed");
            req.getRequestDispatcher("CustomerLogin.html").include(req, res);
        }
        pw.println("</h1></center>");
    }
}

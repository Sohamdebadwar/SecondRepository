package com.pack1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
@WebServlet("/bookTicket")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

       

        String name = req.getParameter("pname");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phno");
        String train = req.getParameter("train");
        int nop = Integer.parseInt(req.getParameter("nop"));
        String source = req.getParameter("source");
        String dest = req.getParameter("dest");
        String gender = req.getParameter("gender");
        String classType = req.getParameter("classType");
        String seat = req.getParameter("seatType");
        String[] facilities = req.getParameterValues("facilities");

        double price = 0;
        switch (classType) {
            case "general": price = 100; break;
            case "sleeper": price = 500; break;
            case "3rd ac": price = 1500; break;
            case "2nd ac": price = 2000; break;
            case "1st ac": price = 4000; break;
        }

        double total = price * nop;
        int berth = (int)(Math.random() * 100);

        req.setAttribute("name", name);
        req.setAttribute("age", age);
        req.setAttribute("phone", phone);
        req.setAttribute("train", train);
        req.setAttribute("nop", nop);
        req.setAttribute("source", source);
        req.setAttribute("dest", dest);
        req.setAttribute("gender", gender);
        req.setAttribute("classType", classType);
        req.setAttribute("seat", seat);
        req.setAttribute("facilities", facilities);
        req.setAttribute("berth", berth);
        req.setAttribute("total", total);

        RequestDispatcher rd = req.getRequestDispatcher("BookingDetails.jsp");
        rd.forward(req, res);
    }
}

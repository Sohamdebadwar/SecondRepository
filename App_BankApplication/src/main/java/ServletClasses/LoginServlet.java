package ServletClasses;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import Entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO dao = new UserDAO();
        User user = dao.validateUser(username, password);
        if (user != null) {
        	System.out.println("Dashboread");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
        	System.out.println("index");
            request.setAttribute("msg", "Invalid Username or Password!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}

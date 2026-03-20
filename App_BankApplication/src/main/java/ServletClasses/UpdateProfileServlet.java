package ServletClasses;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DBConnection;
import Entity.User;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("bank-login.jsp");
            return;
        }

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnection.getConnection();

            // Only update password if provided
            String sql;
            if (password != null && !password.trim().isEmpty()) {
                sql = "UPDATE BANK_USERS SET FULL_NAME=?, EMAIL=?, USERNAME=?, PASSWORD=?, PHONE_NUMBER=? WHERE USER_ID=?";
            } else {
                sql = "UPDATE BANK_USERS SET FULL_NAME=?, EMAIL=?, USERNAME=?, PHONE_NUMBER=? WHERE USER_ID=?";
            }

            ps = conn.prepareStatement(sql);
            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, username);

            if (password != null && !password.trim().isEmpty()) {
                ps.setString(4, password);
                ps.setString(5, phoneNumber);
                ps.setInt(6, user.getUserId());
            } else {
                ps.setString(4, phoneNumber);
                ps.setInt(5, user.getUserId());
            }

            int updated = ps.executeUpdate();
            if (updated > 0) {
                // Update session object too
                user.setFullName(fullName);
                user.setEmail(email);
                user.setUsername(username);
                user.setPhoneNo(phoneNumber);
                session.setAttribute("user", user);

                response.sendRedirect("profile.jsp?success=1");
            } else {
                response.sendRedirect("editProfile.jsp?error=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("editProfile.jsp?error=2");
        } finally {
            try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception ex) {}
        }
    }
}

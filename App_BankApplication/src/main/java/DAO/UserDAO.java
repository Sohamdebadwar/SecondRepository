package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBConnection.DBConnection;
import Entity.User;

public class UserDAO {



    public User validateUser(String username, String password) {
        User user = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DBConnection.getConnection();
            String sql = "SELECT * FROM BANK_USERS WHERE USERNAME=? AND PASSWORD=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("USER_ID"));
                user.setFullName(rs.getString("FULL_NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
                user.setBalance(rs.getDouble("BALANCE"));
                user.setPhoneNo(rs.getString("PHONE_NUMBER"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pst != null) pst.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return user;
    }
}

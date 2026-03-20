package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBConnection.DBConnection;
import Entity.User;

public class RegisterDAO {
      public boolean registerUser(User user) {
        String sql = "INSERT INTO bank_users (FULL_NAME, EMAIL, USERNAME, PASSWORD, PHONE_NUMBER, ACCOUNT_NUMBER, BALANCE, CREATED_AT) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, SYSDATE)";
        try {
        	Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getPhoneNo());
            ps.setString(6, user.getAccountNumber());
            ps.setDouble(7, user.getBalance());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

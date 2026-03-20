package com.pack3.CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pack1.conn.DBConnect;
import com.pack3.CustomerBean.CustomerBean;

public class CustomerRegisterDAO {

    public int register(CustomerBean cb) {
        int rowCount = 0;

        try {
            Connection con = DBConnect.connect();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO CUSTOMER1 VALUES (?,?,?,?,?,?,?)"
            );

            ps.setString(1, cb.getUname());
            ps.setString(2, cb.getPwd());
            ps.setString(3, cb.getFname());
            ps.setString(4, cb.getLname());
            ps.setString(5, cb.getAddress());
            ps.setString(6, cb.getMail());
            ps.setString(7, cb.getMobile());

            rowCount = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}

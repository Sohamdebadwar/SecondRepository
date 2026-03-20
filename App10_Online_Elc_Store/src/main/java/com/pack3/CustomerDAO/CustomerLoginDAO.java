package com.pack3.CustomerDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pack1.conn.DBConnect;
import com.pack3.CustomerBean.CustomerBean;

public class CustomerLoginDAO {

    public CustomerBean validate(String uname, String pwd) {
        CustomerBean cb = null;

        try {
            Connection con = DBConnect.connect();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM CUSTOMER1 WHERE UNAME=? AND PWORD=?"
            );

            ps.setString(1, uname);
            ps.setString(2, pwd);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cb = new CustomerBean();

                cb.setUname(rs.getString("UNAME"));
                cb.setPwd(rs.getString("PWORD"));
                cb.setFname(rs.getString("FNAME"));
                cb.setLname(rs.getString("LNAME"));
                cb.setAddress(rs.getString("ADDR"));
                cb.setMail(rs.getString("MID"));
                cb.setMobile(rs.getString("PHNO"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cb;
    }
}

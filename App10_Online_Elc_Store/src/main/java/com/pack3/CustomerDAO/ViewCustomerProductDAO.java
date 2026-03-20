
package com.pack3.CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pack1.conn.DBConnect;

public class ViewCustomerProductDAO {

    public ResultSet getProducts() {
        ResultSet rs = null;

        try {
            Connection con = DBConnect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCT1 ORDER BY PCODE");
            rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}

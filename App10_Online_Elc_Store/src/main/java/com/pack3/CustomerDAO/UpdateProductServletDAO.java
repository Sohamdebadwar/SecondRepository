package com.pack3.CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pack1.conn.DBConnect;

public class UpdateProductServletDAO {

    public boolean updateQty(String pcode, int newQty) {
        try {
            Connection con = DBConnect.connect();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE PRODUCT1 SET PQTY=? WHERE PCODE=?"
            );

            ps.setString(1, String.valueOf(newQty));
            ps.setString(2, pcode);

             int rowCount = ps.executeUpdate();
            return rowCount > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

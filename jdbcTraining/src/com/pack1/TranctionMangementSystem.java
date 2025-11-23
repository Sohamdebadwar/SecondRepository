package com.pack1;

import java.sql.*;

/*
 * SQL> CREATE TABLE bank_account1 (
  2      acc_no NUMBER PRIMARY KEY,
  3      name VARCHAR2(30),
  4      balance NUMBER(10,2)
  5  );

Table created.
 */
public class TranctionMangementSystem {

    public static void main(String[] args) {
        Connection con = null;
        // ps1 = null;
       // PreparedStatement ps2 = null;

        try {
            // 1. Load Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // 2. Establish Connection
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "soham", "123");

            // 3. Turn off auto-commit for manual transaction control
            con.setAutoCommit(false);

            // 4. Create SQL queries
            String withdrawQuery = "UPDATE bank_account1 SET balance = balance - ? WHERE acc_no = ?";
            String depositQuery = "UPDATE bank_account1 SET balance = balance + ? WHERE acc_no = ?";

            // 5. Create PreparedStatements
            PreparedStatement  ps1 = con.prepareStatement(withdrawQuery);
            ps1.setDouble(1, 500);
            ps1.setInt(2, 101);
            int rows1 = ps1.executeUpdate();
            //System.out.println(rows1);
            if (rows1 >0) {
                con.commit();
                System.out.println("✅ Transaction committed successfully! Money transferred.");
            } else {
                //   con.rollback();
                   System.out.println("❌ Transaction rolled back! Something went wrong.");
               }

            PreparedStatement ps2 = con.prepareStatement(depositQuery);
            ps2.setDouble(1, 500);
            ps2.setInt(2, 102);
            int rows2 = ps2.executeUpdate();

            // 7. Check if both successful
            if (rows2 > 0) {
                con.commit();
                System.out.println("✅ Transaction committed successfully! Money transferred.");
            } else {
             //   con.rollback();
                System.out.println("❌ Transaction rolled back! Something went wrong.");
            }
            System.out.println("Withdraw rows affected: " + rows1);
            System.out.println("Deposit rows affected: " + rows2);


        } catch (Exception e) {
           
            e.printStackTrace();
        } 
        
        }
    
    }


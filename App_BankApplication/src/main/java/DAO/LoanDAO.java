package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Entity.Loan;

public class LoanDAO {

    // Insert Loan
    public boolean applyLoan(Loan loan) {
        boolean f = false;

        try {
        	System.out.println("customer id ="+loan.getCustomerId());
        	System.out.println("getLoanType ="+loan.getLoanType());
        	System.out.println("getAmount  ="+loan.getAmount());
        	System.out.println("getDuration  ="+loan.getDuration());
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO loans (CUSTOMER_ID, LOAN_TYPE, AMOUNT, DURATION, STATUS,APPLY_DATE) VALUES (?, ?, ?, ?,  'Pending', SYSDATE)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, loan.getCustomerId());
            ps.setString(2, loan.getLoanType());
            ps.setDouble(3, loan.getAmount());
            ps.setInt(4, loan.getDuration());

            int i = ps.executeUpdate();
            if (i == 1) f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    // Get all loans (for admin)
    public List<Loan> getAllLoans() {
        List<Loan> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM loans ORDER BY loan_id DESC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Loan l = new Loan();
                l.setLoanId(rs.getInt("loan_id"));
                l.setCustomerId(rs.getInt("customer_id"));
                l.setLoanType(rs.getString("loan_type"));
                l.setAmount(rs.getDouble("amount"));
                l.setDuration(rs.getInt("duration"));
                l.setStatus(rs.getString("status"));
                l.setApplyDate(rs.getString("apply_date"));

                list.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

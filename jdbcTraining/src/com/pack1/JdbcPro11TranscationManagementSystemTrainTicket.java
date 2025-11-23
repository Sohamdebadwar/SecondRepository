package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

public class JdbcPro11TranscationManagementSystemTrainTicket 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String DbUname = "soham";
	String DbPwd = "123";
	
	String sqlQuery1 = "update trainseatavailability set available_seats=available_seats-1 where train_id=? and journey_date=? and class =? and available_seats > 0";
	String sqlQuery2 = "insert into bookingdetails values(?,?,?,?,?)";
	String Query3="select payment_status from customerpayment where customer_id=?";
	String Query4="update bookingdetails set status='Confirmed' where customer_id=?";
	
	public Connection connection()
	{
		Connection con = null;
		try 
		{
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, DbUname, DbPwd);
			System.out.println("connection created ");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	void meth1()
	{
		System.out.println("Implementing transaction Management\n");
		try
		{
			Connection con = connection();
			System.out.println("getAutoCommit()"+con.getAutoCommit()); //true
			con.setAutoCommit(false);		// Disable the AutoCommit
			System.out.println("getAutoCommit()"+con.getAutoCommit()); //false
			
			PreparedStatement pstmt = con.prepareStatement(sqlQuery1);
			pstmt.setString(1,"12345");
			pstmt.setString(2,"10-10-2024");
			pstmt.setString(3,"sleeper");
			int rowCount = pstmt.executeUpdate();
			if(rowCount == 0 )
			{
				throw new RuntimeException("Seat Unlocking Is Unsuccessuful");
			}
			System.out.println("Seat Is Locked");
			Savepoint sp = con.setSavepoint();
			
			PreparedStatement pstmt2 = con.prepareStatement(sqlQuery2);
			pstmt2.setString(1,"b101");
			pstmt2.setString(2,"12345");
			pstmt2.setString(3,"c123");
			pstmt2.setInt(4,1);
			pstmt2.setString(5,"payment pending");
			int rowCount2 = pstmt2.executeUpdate();
			if(rowCount2 == 0 )
			{
				throw new RuntimeException("Seat Booking Is Unsuccessuful");
			}
			System.out.println("Booking Record inserted successfully");
			System.out.println("Waiting for payment confirmation");
			
			PreparedStatement pstmt3=con.prepareStatement(Query3);
			pstmt3.setString(1, "c123");
			ResultSet rs=pstmt3.executeQuery();
			String status ="Failed";
			if(rs.next()) status=rs.getString(1);
			
			if(status.equals("success")) 
			{
				PreparedStatement pstmt4=con.prepareStatement(Query4);
				pstmt4.setString(1, "c123");
				int rowcount3=pstmt4.executeUpdate();
				if(rowcount3==0) throw new RuntimeException("System Failure");
				con.commit();
				System.out.println("ticket Confirmed");
				System.out.println("All the Save points are relased");
			}
			else
			{
				System.out.println("Customer payment is pending");
				System.out.println("Transaction rolling back to the last Save point");
				con.rollback();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		JdbcPro11TranscationManagementSystemTrainTicket obj = new JdbcPro11TranscationManagementSystemTrainTicket();
		obj.meth1();
	}
}

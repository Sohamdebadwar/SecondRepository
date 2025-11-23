package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// SQL>  create table stu (id varchar2(20) primary key,name varchar2(30),fees number(8,2));

public class Student
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUser = "soham";
	String dbPwd = "123";
	
	String sqlQuery1 = "insert into stu values (?,?,?)";
	String sqlQuery2 = "select * from stu";
	String sqlQuery3 = "delete from stu where id=?";
	String sqlQuery4 = "select * from stu where id =?";
	String sqlQuery5 = "update stu set name=? where id=?";
			
	public Connection connect()
	{
		System.out.println("Connection created");
		Connection con = null;
		try 
		{
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	void insertOperation()
	{
		try 
		{
			Connection con = connect();
			PreparedStatement pstmt = con.prepareStatement(sqlQuery1);
			pstmt.setString(1,"101");
			pstmt.setString(2,"soham");
			pstmt.setDouble(3,30000.00);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount ==0 )
			{
				throw new RuntimeException("Data Not Inserted");
			}
			else
			{
				System.out.println("Data Inserted");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	void viewOperation()
	{
		try 
		{
			Connection con = connect();
			PreparedStatement pstmt = con.prepareStatement(sqlQuery2);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	void deleteOperation()
	{
		try 
		{
			Connection con = connect();
			PreparedStatement pstmt = con.prepareStatement(sqlQuery3);
			pstmt.setString(1,"101");
			int rowCount = pstmt.executeUpdate();
						
			if(rowCount ==0 )
			{
				throw new RuntimeException("Data Not Deleted");
			}
			else
			{
				System.out.println("Data Deleted");
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void retriveOperation()
	{
		try 
		{
			Connection con = connect();
			PreparedStatement pstmt = con.prepareStatement(sqlQuery4);
			pstmt.setString(1,"101");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	void UpdateOperation()
	{
		try 
		{
			Connection con = connect();
			PreparedStatement pstmt = con.prepareStatement(sqlQuery5);
			pstmt.setString(1,"anurag");
			pstmt.setString(2,"101");
			int rowCount = pstmt.executeUpdate();
			if(rowCount ==0 )
			{
				throw new RuntimeException("Data Not Updated");
			}
			else
			{
				System.out.println("Data Updated");
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Student stu = new Student();
		//stu.connect();
		//stu.insertOperation();
		stu.viewOperation();
		//stu.deleteOperation();
		//stu.retriveOperation();
		//stu.UpdateOperation();
	}
	
}

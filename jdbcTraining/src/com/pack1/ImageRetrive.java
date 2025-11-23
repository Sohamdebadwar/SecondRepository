package com.pack1;



import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class ImageRetrive
{    
	
	String driver ="oracle.jdbc.OracleDriver";
	String dburl ="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbname ="soham";
	String dbpwd = "123";
	
	
	public Connection connect()
	{
		System.out.println("Connection created");
		Connection con = null;
		try 
		{
			Class.forName(driver);
			con = DriverManager.getConnection(dburl, dbname, dbpwd);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return con;
		
	}
    
  void meth1()
  {
	  Connection con = connect();
	  try
	  {
		  PreparedStatement pstmt = con.prepareStatement("insert into student01 values (?,?)");
		  System.out.println("Enter Student Id");
		  pstmt.setInt(1, 101);
		  System.out.println("Add Student Image");
		  pstmt.setBlob(2, new FileInputStream("D:\\Image\\Blachorse.jpg"));
		  int rowCount = pstmt.executeUpdate();
		  if(rowCount>0)
		  {
			  System.out.println("Data Inserted");
		  }
		  else
		  {
			  throw new RuntimeException("Data NOT Inserted");
		  }
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  public static void main(String[] args) 
  {
	  ImageRetrive obj = new ImageRetrive();
	  obj.meth1();
	  
  }

 
}
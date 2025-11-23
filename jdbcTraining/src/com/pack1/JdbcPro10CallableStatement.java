package com.pack1;

import java.awt.Window.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class JdbcPro10CallableStatement 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	
	Scanner sc = new Scanner(System.in);
	public Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, DbUname, DbPwd);
			System.out.println("Connection Created");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	
	void meth1()
	{
		System.out.println("Inplementing Callable Statement meth1\n");
		try 
		{
			Connection con = connect();
			CallableStatement cstmt = con.prepareCall("{call InsertEmpData(?,?,?,?,?)}");
			
			System.out.println("Enter Emloyee Id");
			String id = sc.nextLine();
			System.out.println("Enter Emloyee Name");
			String name = sc.nextLine();
			System.out.println("Enter Emloyee Desg");
			String desg = sc.nextLine();
			System.out.println("Enter Emloyee Basic Salary");
			int bsal = Integer.parseInt(sc.nextLine());
			float tsal =  bsal + (0.35f * bsal)+(0.15f*bsal);
			
			cstmt.setString(1, id);
			cstmt.setString(2, name);
			cstmt.setString(3, desg);
			cstmt.setInt(4, bsal);
			cstmt.setFloat(5, tsal);
			cstmt.execute();
			System.out.println("Data Inserted");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void meth2()
	{
		System.out.println("Inplementing Callable Statement meth2\n");
		
		try {
			Connection con = connect();
			CallableStatement cstmt = con.prepareCall("{call reteriveData(?,?,?,?,?)}");
			System.out.println("Enter the emp id :");
			String eid = sc.nextLine();
			cstmt.setString(1,eid);
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.registerOutParameter(3,Types.VARCHAR);
			cstmt.registerOutParameter(4,Types.INTEGER);
			cstmt.registerOutParameter(5,Types.FLOAT);
			
			cstmt.execute();
			
			System.out.println("Employee Data");
			System.out.println("Employee Id :"+eid);
			System.out.println("Employee Name :"+cstmt.getString(2));
			System.out.println("Employee Desg :"+cstmt.getString(3));
			System.out.println("Employee Basic Salary :"+cstmt.getInt(4));
			System.out.println("Employee Total Salary:"+cstmt.getFloat(5));
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	void meth3()
	{
		System.out.println("Inplementing Callable Statement meth3\n");
		try 
		{
			Connection con = connect();
			CallableStatement cstmt = con.prepareCall("{call ?:= reteriveTsal(?)}");
			System.out.println("Enter the emp id :");
			String eid = sc.nextLine();
			cstmt.setString(2,eid);
			cstmt.registerOutParameter(1, Types.FLOAT);
			cstmt.execute();
			
			System.out.println("Employee Data");
			System.out.println("Employee Id :"+eid);
			System.out.println("Employee Total Salary:"+cstmt.getFloat(1));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)
	{
		JdbcPro10CallableStatement obj = new JdbcPro10CallableStatement();
		//obj.meth1();
		//obj.meth2();
		obj.meth3();
	}
	
	

}

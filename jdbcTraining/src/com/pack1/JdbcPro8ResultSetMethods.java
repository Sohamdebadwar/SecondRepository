package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPro8ResultSetMethods
{

	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	
	Scanner sc = new Scanner(System.in);
	
	Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, DbUname, DbPwd);
			System.out.println("Connection Created");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	void meth1()
	{
		Connection con = connect();
		System.out.println("Retriving data resultset readonly !!!\n");
		try
		{
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select * from employee");
			rs.afterLast();
			rs.beforeFirst();
			
			//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			//java.sql.SQLException: Result set after last row
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			System.out.println("------------------------------------");
			
			rs.last();
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			System.out.println("----------------------------------");
			
			rs.first();
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			System.out.println("----------------------------------");
			
			rs.afterLast();
			while(rs.previous())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			System.out.println("----------------------------------");
			rs.absolute(2);
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				System.out.println("----------------------------------");
			}
			
			rs.absolute(-5);
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				System.out.println("----------------------------------");
			}
			
			rs.relative(3);
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				System.out.println("----------------------------------");
			}
			
			rs.absolute(3);
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				System.out.println("----------------------------------");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	void meth2()
	{
		Connection con = connect();
		System.out.println("Updating salary using Statement !!!\n");
		
		try 
		{
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select eid, efname, elname, esal from employee");
			
			while (rs.next()) 
			{
				String eid = rs.getString(1);
				if (eid.equals("104")) 
				{
					System.out.println("Updating sal of employee id as : "+eid);
					rs.updateInt("esal",95000);
					rs.updateRow();	
				}
			}
			System.out.println("Data Updated");
			ResultSet rs2 = con.createStatement(1004,1007).executeQuery("select * from employee");
			rs2.absolute(4);
			System.out.println(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getInt(4)+" "+rs2.getString(5));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args)
	{
		JdbcPro8ResultSetMethods obj =new JdbcPro8ResultSetMethods() ;
		
	//	obj.meth1();
		obj.meth2();
	}
}


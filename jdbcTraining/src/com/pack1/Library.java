package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class Library 
{

	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	
	Scanner sc = new Scanner(System.in);
	
	String sqlQuery1 ="select * from ";
	
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
	
	
	void retrive()
	{
		System.out.println("Retriving the data\n");
		System.out.println("From which table you want to view data");
		String t_name = sc.nextLine();
		
		try
		{
			Connection con = connect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery1.concat(t_name));
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	void adding()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the bookId");
		String b_id = sc.nextLine();
		
		System.out.println("Enter the bookname");
		String b_name = sc.nextLine();
		
		System.out.println("Enter the Author");
		String author = sc.nextLine();
		
		System.out.println("Enter the Genere");
		String genere = sc.nextLine();
		
		System.out.println("Enter the Book Cost");
		int b_cost = Integer.parseInt(sc.nextLine());
		
		sc.close();
		
		
		try
		{
			Connection con = connect();
			Statement stmt = con.createStatement();
			int rowCount = stmt.executeUpdate("insert into library values('"+b_id+"','"+b_name+"','"+author+"','"+genere+"',"+b_cost+")");
			
			
			if(rowCount >0)
			{
				System.out.println("Inserted data in table");
				
			}
			else 
			{
				throw new RuntimeException();
			}
		}
		catch(SQLIntegrityConstraintViolationException sicve)
		{
			System.out.println("Duplicate data");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	void del()
	{
		System.out.println("delete row from table based on bid");
		System.out.println("Enter the book Id");
		String b_id= sc.nextLine();
		
		
		try
		{
			Connection con = connect();
			Statement stmt = con.createStatement();
			int rowCount = stmt.executeUpdate("delete from library where bookid ='"+b_id+"'");
			
						
			if(rowCount >0)
			{
				System.out.println("Data deleted");
			}
			else
			{
				System.out.println("Data Not Deleted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) 
	{
		Library lib = new Library();
		//lib.adding();
		lib.retrive();
		//lib.del();
		
	}
}

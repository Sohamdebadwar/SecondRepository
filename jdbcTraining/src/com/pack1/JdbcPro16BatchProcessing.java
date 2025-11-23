package com.pack1;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

import java.sql.Connection;

public class JdbcPro16BatchProcessing 
{
	String driver ="oracle.jdbc.OracleDriver";
	String dburl ="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbname ="soham";
	String dbpwd = "123";
	
	Scanner sc = new Scanner(System.in);
	
	void meth1()
	{
		System.out.println("Implementing Batch-Processing");
		
		try
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dburl, dbname, dbpwd);
			Statement stmt = con.createStatement();
			
			System.out.println("How many queries you want to add to the batch");
			int num = Integer.parseInt(sc.nextLine());
			for(int i=1;i<=num;i++)
			{
				System.out.println("Enter "+i+" query");
				String sqlQuery = sc.nextLine();
				stmt.addBatch(sqlQuery);
			}
			
			int arr[] = stmt.executeBatch();
			System.out.println(Arrays.toString(arr));
			System.out.println("batch Processing is Done");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		new JdbcPro16BatchProcessing().meth1();
	}
	
	
}

package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPro3InsertOperation 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	String squQuery1 ="insert into employee values('109','abhishekh','samal',50000,'odisha')";
	Scanner sc = new Scanner(System.in);
	
	void insertData()
	{
		System.out.println("Inserting data into the employee table");
		
		try
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dbUrl, DbUname, DbPwd);
			Statement stmt = con.createStatement();
			int rowCount = stmt.executeUpdate(squQuery1);
			if(rowCount>0)
			{
				
				System.out.println("Data Inserted");
				System.out.println("Do you Want view Data (y/n)");
				char choice = sc.nextLine().charAt(0);
				
				switch(choice)
				{
					case 'Y','y' ->
					{
						new JdbcPro2Retrived().meth1();
					}
					case 'N','n'->
					{
						System.exit(0);
					}
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		new JdbcPro3InsertOperation().insertData();
	}

}

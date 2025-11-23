package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro2Retrived 
{
	String driver = "oracle.jdbc.OracleDriver";
	//String dbUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
	String dbUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	String squQuery1 ="select * from employee";
	
	void meth1()
	{
		System.out.println("Reteriving the data From th eemployee Table ");
		
		try
		{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dbUrl, DbUname, DbPwd);
			System.out.println("Connection Created\n");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(squQuery1);
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			System.out.println("\nData Retrived");
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args)
	{
		new JdbcPro2Retrived().meth1();
	}

}

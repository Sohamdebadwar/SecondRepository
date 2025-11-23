package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcPro1Connection 
{
	String driver = "oracle.jdbc.OracleDriver";
	//String dbUrl = "jdbc:oracle:thin:@localhost:1521:oracle21";
	//String dbUrl = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
	//String dbUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	void Meth1()
	{
		System.out.println("Establishing Connection to the database");
		
		try
		{
			Class.forName(driver); //Loading The Class
			Connection connection = DriverManager.getConnection(dbUrl, DbUname, DbPwd);
			System.out.println("Database Connected Successfully !!!");
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args)
	{
		new JdbcPro1Connection().Meth1();
	}
}

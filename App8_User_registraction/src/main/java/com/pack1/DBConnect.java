package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect 
{
	private static Connection con = null;

	public DBConnect() {}
	
	static 
	{
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(DBInfo.dburl, DBInfo.dbname, DBInfo.dbpwd);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static Connection connect()
	{
		return con;
	}
}

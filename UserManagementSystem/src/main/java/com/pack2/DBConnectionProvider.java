package com.pack2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionProvider 
{
	private static Connection con = null;

	public DBConnectionProvider() {}
	
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

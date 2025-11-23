package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPooling 
{
	String driver;
	String dburl;
	String dbname;
	String dbpwd;
	
	
	
	Vector<Connection> v = new Vector<Connection>();
	
	public ConnectionPooling(String driver, String dburl, String dbname, String dbpwd) 
	{
		super();
		this.driver = driver;
		this.dburl = dburl;
		this.dbname = dbname;
		this.dbpwd = dbpwd;
	}
	
	public void conInitialization()
	{
		System.out.println("Creating '5' Connection Objects\n");
		for(int i=1;i<=5;i++)
		{
			try 
			{
				Class.forName(driver);
				Connection con = DriverManager.getConnection(dburl, dbname,dbpwd);
				v.addElement(con);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("There are "+v.size()+" Connection Objects are available in the pool\n");
		for(Object obj : v)
		{
			System.out.println(obj);
		}
	}
	
	public Connection conAcquisition()
	{
		System.out.println("Assigning the Connection Object");
		Connection con = v.elementAt(0);
		v.remove(0);
		return con;
	}
	
	public void conReturn(Connection con)
	{
		System.out.println("Adding the connection object back to the Connection pool\n");
		v.add(con);
		
		for(Object obj :v)
		{
			System.out.println(obj);
		}
	}
}

package com.pack1;

import java.sql.Connection;

public class JdbcPro13ConnectionPooling
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String DbUname = "soham";
	String DbPwd = "123";
	
	void meth1()
	{
		ConnectionPooling cp = new ConnectionPooling(driver, dbUrl, DbUname, DbPwd);
		cp.conInitialization();
		System.out.println("============> User-1 <=============");
		Connection con1 = cp.conAcquisition();
		System.out.println("Connection Pool Size "+cp.v.size());
		System.out.println("============> User-2 <=============");
		Connection con2 = cp.conAcquisition();
		System.out.println("Connection Pool Size "+cp.v.size());
		System.out.println("============> User-3 <=============");
		Connection con3 = cp.conAcquisition();
		System.out.println("Connection Pool Size "+cp.v.size());
		
		cp.conReturn(con1);
		cp.conReturn(con2);
		cp.conReturn(con3);
		
	}
	
	public static void main(String[] args) 
	{
		JdbcPro13ConnectionPooling obj = new JdbcPro13ConnectionPooling();
		obj.meth1();
	}
}

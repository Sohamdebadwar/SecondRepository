package com.pack1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcPro14MetaData 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	
	String sqlQuery = "select * from employee where eid = ?";
	
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
		System.out.println("Implementing the MetaData in JDBC \n");
		
		try
		{
			Connection con = connect();
			DatabaseMetaData dmtdt = con.getMetaData();
			System.out.println("\ngetDatabaseProductName : "+dmtdt.getDatabaseProductName());
			System.out.println("getDatabaseProductVersion : "+dmtdt.getDatabaseProductVersion());
			System.out.println("getDriverName : "+dmtdt.getDriverName());
			System.out.println("supportsStoredProcedures : "+dmtdt.supportsStoredProcedures());
			
			PreparedStatement pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1,"101");
			ResultSet rs = pstmt.executeQuery();
			
			ParameterMetaData pmtdt = pstmt.getParameterMetaData();
			System.out.println("\ngetParameterCount : "+	pmtdt.getParameterCount());
			System.out.println("getParameterType : "+pmtdt.getParameterType(1));
			System.out.println("getParameterMode : "+pmtdt.getParameterMode(1));
			System.out.println("isNullable : "+pmtdt.isNullable(1));
			
			ResultSetMetaData rsmt = rs.getMetaData();
			System.out.println("\ngetColumnCount : "+rsmt.getColumnCount());
			System.out.println("getColumnName : "+rsmt.getColumnName(1));
			System.out.println("getColumnDisplaySize : "+rsmt.getColumnDisplaySize(1));
			System.out.println("isAutoIncrement : "+rsmt.isAutoIncrement(1));
			
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.setUrl(dbUrl);
			crs.setUsername(DbUname);
			crs.setPassword(DbPwd);
			crs.setCommand("select * from employee");
			crs.execute();
			
			ResultSetMetaData rsmt1 = crs.getMetaData();
			System.out.println("\ngetColumnCount : "+rsmt1.getColumnCount());
			System.out.println("getColumnName : "+rsmt1.getColumnName(1));
			System.out.println("getColumnDisplaySize : "+rsmt1.getColumnDisplaySize(1));
			System.out.println("isAutoIncrement : "+rsmt1.isAutoIncrement(1));
				
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		JdbcPro14MetaData obj = new JdbcPro14MetaData();
		obj.meth1();
	}

}

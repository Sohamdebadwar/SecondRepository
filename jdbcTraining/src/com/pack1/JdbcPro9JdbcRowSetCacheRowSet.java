package com.pack1;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcPro9JdbcRowSetCacheRowSet 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	
	void meth1()
	{
		System.out.println("Implementing JdbcRowSet ");
		try {
			RowSetFactory rsf = RowSetProvider.newFactory();
			JdbcRowSet jrs = rsf.createJdbcRowSet();
			jrs.setUrl(dbUrl);
			jrs.setUsername(DbUname);
			jrs.setPassword(DbPwd);
			jrs.setCommand("Select * from employee");
			jrs.execute();
			
			jrs.last();
			System.out.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
			
			jrs.absolute(4);
			System.out.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void meth2()
	{
		System.out.println("Implementing CacheRowSet ");
		try
		{
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.setUrl(dbUrl);
			crs.setUsername(DbUname);
			crs.setPassword(DbPwd);
			crs.setCommand("select * from employee");
			crs.execute();
			while(crs.next())
			{
				if(crs.getString(1).contentEquals("104"))
				{
					crs.updateString("eaddress", "mumbai");
					crs.updateRow();
				}
			}
			crs.acceptChanges();
			System.out.println("Data Updated");
			crs.beforeFirst();
			while(crs.next())
			{
				if(crs.getString(1).equals("104"))
				{
					System.out.println(crs.getString(1)+" "+crs.getString(2)+" "+crs.getString(3)+" "+crs.getInt(4)+" "+crs.getString(5));
				}
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		JdbcPro9JdbcRowSetCacheRowSet obj = new JdbcPro9JdbcRowSetCacheRowSet();
		//obj.meth1();
		obj.meth2();

	}

}

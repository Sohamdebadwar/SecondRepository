package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPro4CURDCreateStatement 
{		
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	
	Scanner sc = new Scanner(System.in);
	
	String sqlQuery1 ="select * from ";
	String sqlQuery2 = "insert into employee values()";
	String sqlQuery3 = "select * from employee where eid= ";
	String sqlQuery4 = "UPDATE employee SET esal = 60000 WHERE eid = 101";
	String sqlQuery5 = "delete from employee where e_id='101'";

	
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
		System.out.println("Retriving the data\n");
		System.out.println("From which table you want to view data");
		String t_name = sc.nextLine();
		
		try
		{
			Connection con = connect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery1.concat(t_name));
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	void meth2()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the employee Id");
		String e_id = sc.nextLine();
		
		System.out.println("Enter the employee Fname");
		String e_fname = sc.nextLine();
		
		System.out.println("Enter the employee Lname");
		String e_lname = sc.nextLine();
		
		System.out.println("Enter the employee salary");
		int e_sal = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter the employee add");
		String e_add = sc.nextLine();
		
		sc.close();
		
		
		try
		{
			Connection con = connect();
			Statement stmt = con.createStatement();
			int rowCount = stmt.executeUpdate("insert into employee values('"+e_id+"','"+e_fname+"','"+e_lname+"',"+e_sal+",'"+e_add+"')");
			
			if(rowCount >0)
			{
				System.out.println("Inserted data in table");
				meth1();
			}
			else 
			{
				throw new RuntimeException();
			}
		}
		catch(SQLIntegrityConstraintViolationException sicve)
		{
			System.out.println("Duplicate data");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	void meth3()
	{
		System.out.println("Retriveing the specific row on employee Id");
		System.out.println("Enter the Employee Id");
		String e_id= sc.nextLine();
		
		
		try
		{
			Connection con = connect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee where eid= '"+e_id+"'");
			
			if(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			else
			{
				throw new SQLIntegrityConstraintViolationException();		
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void meth4()
	{
		System.out.println("updating sal based on eid");
		System.out.println("Enter the Employee Id");
		String e_id= sc.nextLine();
		
		System.out.println("Enter the Employee salary");
		int e_sal = Integer.parseInt(sc.nextLine());

		
		try
		{
			Connection con = connect();
			Statement stmt = con.createStatement();
			int rowCount = stmt.executeUpdate("UPDATE employee SET esal = "+e_sal+" WHERE eid = '"+e_id+"'");
			meth1();
			
			if(rowCount >0)
			{
				System.out.println("Data Updated");
			}
			else
			{
				System.out.println("Data Not Updated");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void meth5()
	{
		System.out.println("delete row from table based on eid");
		System.out.println("Enter the Employee Id");
		String e_id= sc.nextLine();
		
		
		try
		{
			Connection con = connect();
			Statement stmt = con.createStatement();
			int rowCount = stmt.executeUpdate("delete from employee where eid ='"+e_id+"'");
			meth1();
			
			if(rowCount >0)
			{
				System.out.println("Data deleted");
			}
			else
			{
				System.out.println("Data Not Deleted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		JdbcPro4CURDCreateStatement obj = new  JdbcPro4CURDCreateStatement();
		//obj.meth1();
		//obj.meth2();
		//obj.meth3();
		//obj.meth4();
		obj.meth5();
	}
}

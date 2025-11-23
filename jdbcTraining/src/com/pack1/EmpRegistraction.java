package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpRegistraction 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	
	Scanner sc = new Scanner (System.in);
	Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, DbUname, DbPwd);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	void verification()
	{
		System.out.println("Are you Registered allready ? Yes/No");
		String option = sc.next().toLowerCase();
		if(option.equals("yes"))
		{
			System.out.println("Welcom to login page please enter your Username and password\n");
			System.out.println("Enter id");sc.nextLine();
			String userid = sc.nextLine();
			System.out.println("Enter password");
			int pwd = Integer.parseInt(sc.nextLine());
			
			if(userid.equals(retrivingEmpId(userid)) && pwd == (retrivingEmpPassword(userid)))
			{
				System.out.println("Login Successfull");
				
				System.out.println("Enter 1 for view the employee data\n enter 2 for Update the employee data");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice)
				{
				case 1->
				  {
					  retrivingData();
				  }
				case 2->
				  {
					  dataUpdating();
				  }
				  case 3 ->
				  {
					  System.out.println("Thank you for visiting!!!!");
					  System.exit(0);
				  }
				  default ->
				  {
					  System.out.println("Wrong input");
				  }
				}
				System.exit(0);
			}
			
		}
		
	   if(option.equals("no"))
	   {
		 System.out.println("Pleas register first");
		 employeeRegistration();
		 System.exit(0);
		 
	   }
	   else
	   {
		   System.err.println("      Wrong Input!!!   \n Please Inter currect Input");
	   }
		
	}
	
	void retrivingData()
	{
          System.out.println("Reteriving the data from Employee table\n");
          Connection con = connect();
          try
          {
        	     
        	      Statement stm = con.createStatement();
        	      ResultSet rs = stm.executeQuery("select * from EMPREGISTRATION");
        	      while(rs.next())
        	      {
        	    	  
        	    	  System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getInt(7));
        	      }
        	      System.out.println("\nData retrived\n");
          }
          catch(Exception e)
          {
        	     e.printStackTrace();
          }
	}
	
	void dataUpdating()
	{
		System.out.println("Updating Employee Data");
		System.out.println("Enter employee id");
		String e_id = sc.nextLine();
		System.out.println("Enter update address");
		String newAdd = sc.nextLine();
		try
		{
			Connection con = connect();
			Statement stm = con.createStatement();
			int rowCount = stm.executeUpdate("update EMPREGISTRATION set address = '"+newAdd+"' where empid = '"+e_id+"'");
			if(rowCount>0)
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
	void employeeRegistration()
	{

		try
		{
			System.out.println("Enter data here for registration");
			sc.nextLine();
			System.out.println("Enter emp id");
			String e_id = sc.nextLine();
			
			System.out.println("Enter emp First name");
			String e_fname = sc.nextLine();
			
			System.out.println("Enter emp Last name");
			String e_lname = sc.nextLine();
			
			System.out.println("Enter emp phone number");
			int e_phn = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter emp address");
			String e_address = sc.nextLine();
			
			System.out.println("Enter emp mail Id");
			String mailid = sc.nextLine();
			
			System.out.println("Enter emp Pssword");
			int pwd = Integer.parseInt(sc.nextLine());
			
			Connection con = connect();
			Statement stm = con.createStatement();
			int rowCount = stm.executeUpdate("insert into EMPREGISTRATION values('"+e_id+"',"+pwd+",'"+e_fname+"','"+e_lname+"','"+e_address+"','"+mailid+"',"+e_phn+")");
			if(rowCount>0)
			{
				System.out.println("Data inseted");
				
			}
			else 
			{
				throw new SQLIntegrityConstraintViolationException();			
			}
		}
		catch(SQLIntegrityConstraintViolationException sicve)
		{
			System.out.println("Duplicate id is not allowed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	String retrivingEmpId(String eid)
	{
          
          Connection con = connect();
          String empid = null;
          
          try
          {
        	     
        	      Statement stm = con.createStatement();
        	      ResultSet rs = stm.executeQuery("select * from EMPREGISTRATION where empid = "+eid);
        	      while(rs.next())
        	      {
        	    	     empid=rs.getString(1);
        	      }
          }
          catch(Exception e)
          {
        	     e.printStackTrace();
          }
          return empid;
	}
	int retrivingEmpPassword(String eid)
	{
          
          Connection con = connect();
          int pwd = 0;
          try
          {
        	     
        	      Statement stm = con.createStatement();
        	      ResultSet rs = stm.executeQuery("select * from EMPREGISTRATION where empid = "+eid);
        	      while(rs.next())
        	      {
        	    	     pwd=rs.getInt(2);
        	      }
          }
          catch(Exception e)
          {
        	     e.printStackTrace();
          }
          return pwd;
	}

	public static void main(String[] args) 
	{
		EmpRegistraction obj = new EmpRegistraction();
		obj.verification();

	}

}
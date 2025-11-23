package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class JdbcPro6CURDPrepareStatement 
{
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String DbUname = "system";
	String DbPwd = "tiger";
	
	Scanner sc = new Scanner(System.in);
	
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
	
	void operations()
	{
		Connection con = connect();
		
		try
		{
			PreparedStatement pstmt1 = con.prepareStatement("insert into patient values(?,?,?,?)");
			PreparedStatement pstmt2 = con.prepareStatement("select  * from patient where pid=?");
			PreparedStatement pstmt3 = con.prepareStatement("select * from patient");
			PreparedStatement pstmt4 = con.prepareStatement("update patient set age=? where pid=?");
			PreparedStatement pstmt5 = con.prepareStatement("delete from patient where pid=?");
			
			while(true)
			{
				System.out.println("Welcome to patient portal\n");
				System.out.println("1.Add patient\n2.View Patient\n3.Retrive Patient Data\n4.Upadate Pateint Data\n5.Delete Patient Data\n6.Exit");
				System.out.println("Enter your Choice");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice)
				{
					case 1 ->
					{
						System.out.println("\nAdding The Patient Data");
						System.out.println("Enter The Patient Id");
						String p_id = sc.nextLine();
						System.out.println("Enter The Patient name");
						String p_name = sc.nextLine();
						System.out.println("Enter The Patient age");
						int p_age = Integer.parseInt(sc.nextLine());
						System.out.println("Enter The Patient Contact");
						long p_contact = Long.parseLong(sc.nextLine());
						
						pstmt1.setString(1, p_id);
						pstmt1.setString(2, p_name);
						pstmt1.setInt(3, p_age);
						pstmt1.setLong(4,p_contact);
						
						int rowCount = pstmt1.executeUpdate();
						if(rowCount>0)
						{
							System.out.println("Data Inserted");
						}
						else
						{
						System.out.println("Data Not Inserted");
						}
						
						
					}
					case 2 -> 
					{
						System.out.println("\nViewing The Patient Data");
						System.out.println("Enter patient id");
						String p_id2= sc.nextLine();
						pstmt2.setString(1, p_id2);
						ResultSet rs1 = pstmt2.executeQuery();
						if(rs1.next())
						{
							System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getLong(4));
						}
						
					}
					case 3 ->
					{
						System.out.println("\nRetrivewing The Patient Data");
						ResultSet rs2 = pstmt3.executeQuery();
						while(rs2.next())
						{
							System.out.println(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getInt(3)+" "+rs2.getLong(4));
						}
					}
					case 4 -> 
					{
						System.out.println("\nUpdating The Patient Data");
						System.out.println("Enter Patient Id");
						String p_id3= sc.nextLine();
						System.out.println("Enter the Patient Age");
						int p_age2 = Integer.parseInt(sc.nextLine());
						pstmt4.setInt(1, p_age2);
						pstmt4.setString(2, p_id3);
						int rowCount2 = pstmt4.executeUpdate();
						if(rowCount2>0)
						{
							System.out.println("Data Updated");
						}
						else
						{
							System.out.println("Data Not Updated");
						}
					}
					case 5 -> 
					{
						System.out.println("\nDeleting The Patient Data");
						System.out.println("Enter Patient Id");
						String p_id4 = sc.nextLine();
						pstmt5.setString(1, p_id4);
						int rowCount3 = pstmt5.executeUpdate();
						if(rowCount3>0)
						{
							System.out.println("Data Deleted");
						}
						else
						{
							System.out.println("Data not Deleted");
						}
					}
					case 6 -> 
					{	
						System.out.println("\nThank You For Visiting");
						System.exit(0);
					}
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
		JdbcPro6CURDPrepareStatement pro6 = new JdbcPro6CURDPrepareStatement();
		pro6.operations();
	}
}

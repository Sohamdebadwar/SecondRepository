package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
/*
 * SQL> create table registration(username varchar2(25) primary key,password  varchar2(25),firstname varchar2(25),lastname varchar2(25),mailid varchar2(25),phone  varchar2(10));

Table created.
 */
public class UserRegisterDao 
{
	public int insertRecord(UserBean ub)
	{
		int rowCount = 0;
		try 
		{
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("insert into registration values (?,?,?,?,?,?)");
			pstmt.setString(1,ub.getuName());
			pstmt.setString(2,ub.getuPwd());
			pstmt.setString(3,ub.getuFname());
			pstmt.setString(4,ub.getuLname());
			pstmt.setString(5,ub.getuMail());
			pstmt.setString(6,ub.getuPhon());
			
			rowCount = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
		
	}
}

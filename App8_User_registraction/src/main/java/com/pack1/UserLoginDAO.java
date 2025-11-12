package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDAO 
{
	public UserBean chaeckLogin(String uname,String upwd)
	{
		UserBean ub = null;
		  
		try
		{
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("select * from registration where USERNAME = ? and PASSWORD = ?");
			pstmt.setString(1, uname);
			pstmt.setString(2, upwd);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				ub = new UserBean();
				ub.setuName(rs.getString(1));
				ub.setuPwd(rs.getString(2));
				ub.setuFname(rs.getString(3));
				ub.setuLname(rs.getString(4));
				ub.setuMail(rs.getString(5));
				ub.setuPnno(rs.getString(6));
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ub;
		
	}
}

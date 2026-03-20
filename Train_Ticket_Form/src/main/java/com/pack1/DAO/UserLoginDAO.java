package com.pack1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pack1.Conn.DBConnect;
import com.pack1.UserBean.UserBean;


public class UserLoginDAO 
{
	public UserBean chaeckLogin(String uname,String upwd)
	{
		UserBean ub = null;
		  
		try
		{
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("select * from Login where NAME = ? and PASSWORD = ?");
			pstmt.setString(1, uname);
			pstmt.setString(2, upwd);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				ub = new UserBean();
				ub.setU_name(rs.getString(1));
				ub.setU_pwd(rs.getString(2));
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ub;
		
	}
}

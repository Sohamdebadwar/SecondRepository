package com.pack1.AdminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pack1.AdminBean.AdminBean;
import com.pack1.conn.DBConnect;

public class AdminLoginDAO 
{
	public AdminBean checkAdminLogin(String uname,String Upwd)
	{
		AdminBean abean = null;
		
		try 
		{
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("Select * from ADMIN1 where uname=? and pword =?");
			pstmt.setString(1, uname);
			pstmt.setString(2, Upwd);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				abean = new AdminBean();
				abean.setA_uname(rs.getString(1));
				abean.setA_pwd(rs.getString(2));
				abean.setA_fname(rs.getString(3));
				abean.setA_lname(rs.getString(4));
				abean.setA_addr(rs.getString(5));
				abean.setA_mail(rs.getString(6));
				abean.setA_phno(rs.getString(7));
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return abean;
		
	}
}

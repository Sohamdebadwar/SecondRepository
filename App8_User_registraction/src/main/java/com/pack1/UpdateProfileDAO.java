package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
//registration

public class UpdateProfileDAO 
{
	public int UpdateData(UserBean ub)
	{
		int rowCount = 0;
		try 
		{
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("update registration set firstname =?,lastname=?,mailid=?,phone=? where username =?");
			pstmt.setString(1, ub.getuFname());
			pstmt.setString(2, ub.getuLname());
			pstmt.setString(3, ub.getuMail());
			pstmt.setString(4, ub.getuPhon());
			pstmt.setString(5, ub.getuName());
			rowCount = pstmt.executeUpdate();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}
}

package com.pack2.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pack1.conn.DBConnect;
import com.pack2.ProductBean.ProductBean;

public class DeleteProductDAO 
{
	public int deleteProduct(String pcode)
	{
		int rowCount = 0;
		
		try
		{
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("delete from product1 where pcode=?");
			pstmt.setString(1, pcode);
			rowCount = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return rowCount;
	}
}

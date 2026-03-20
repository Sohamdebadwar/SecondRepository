package com.pack2.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pack1.conn.DBConnect;
import com.pack2.ProductBean.ProductBean;

public class UpdateProductDAO 
{
	public int updateProduct(ProductBean pb)
	{
		int rowCount = 0;
		
		try
		{
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("update product1 set pprice=?, pqty=? where pcode=?");
			pstmt.setString(1,pb.getP_price());
			pstmt.setString(2,pb.getP_qty());
			pstmt.setString(3,pb.getP_code());
			rowCount = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return rowCount;
	}
}

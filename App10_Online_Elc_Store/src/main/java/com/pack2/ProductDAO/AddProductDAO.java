package com.pack2.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pack1.conn.DBConnect;
import com.pack2.ProductBean.ProductBean;

public class AddProductDAO 
{
	public int insertProduct(ProductBean pb) 
	{
		int rowCount = 0;
		try 
		{
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("insert into PRODUCT1 values (?,?,?,?,?)");
			pstmt.setString(1,pb.getP_code());
			pstmt.setString(2,pb.getP_name());
			pstmt.setString(3,pb.getP_company());
			pstmt.setString(4,pb.getP_price());
			pstmt.setString(5,pb.getP_qty());
			
			rowCount = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
		return rowCount;
	}
}

/*

package com.pack2.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pack1.conn.DBConnect;
import com.pack2.ProductBean.ProductBean;

public class AddProductDAO 
{
	public int insertProduct(ProductBean pb) throws Exception
	{
		int rowCount = 0;
		try 
		{
			Connection con = DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("insert into PRODUCT1 values (?,?,?,?,?)");
			pstmt.setString(1,pb.getP_code());
			pstmt.setString(2,pb.getP_name());
			pstmt.setString(3,pb.getP_company());
			pstmt.setString(4,pb.getP_price());
			pstmt.setString(5,pb.getP_qty());
			
			rowCount = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			throw e;
		}
		
		return rowCount;
	}
}
*/
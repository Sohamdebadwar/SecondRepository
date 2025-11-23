//image , file insert And retried 

package com.pack1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcPro15FileImageStore 
{
	String driver ="oracle.jdbc.OracleDriver";
	String dburl ="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbname ="soham";
	String dbpwd = "123";
	
	String sqlQuery1 = "insert into mydata values(?,?)";
	String sqlQuery2 = "select pic_data from mydata where id=?";
	String sqlQuery3 = "insert into mydata2 values(?,?)";
	String sqlQuery4 = "select file_data from mydata2 where id=?";
	Connection connect() 
	{
		Connection con = null;
		try 
		{
			Class.forName(driver);
			con = DriverManager.getConnection(dburl,dbname,dbpwd);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return con;
	}
	
	void meth1()
	{
		System.out.println("Inserting an Image into Database");
		Connection con = connect();
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(sqlQuery1);
			pstmt.setString(1,"101");
			try 
			{
				FileInputStream fis = new FileInputStream("C:\\NIT\\pic1.jpg");			
				pstmt.setBlob(2, fis,fis.available());
			} 
			catch (Exception e) 
			{
				System.out.println("File path is wrong");			
				e.printStackTrace();
			}
			int rowCount = pstmt.executeUpdate();
			if(rowCount ==0)
			{
				throw new RuntimeException("Data Not Inserted");
			}
			else
			{
				System.out.println("Data Inserted");
			}
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}
	
	void meth2()
	{
		System.out.println("Reteriving image from the database");
		try
		{
			Connection con = connect();
			PreparedStatement pstmt = con.prepareStatement(sqlQuery2);
			pstmt.setString(1,"101");
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				Blob b = rs.getBlob(1);
				byte[] arr = b.getBytes(1,(int) b.length());
				
				FileOutputStream fos = new FileOutputStream("C:\\NIT\\pic2.jpg");
				fos.write(arr);
				System.out.println("Image Reterived !!!!");
				fos.close();
			}
			else
			{
				throw new RuntimeException("Reterived the image failed with fatel error !!!");
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	void meth3()
	{
		System.out.println("Passing a file into the Database");
		
		try 
		{
			Connection con = connect();
			System.out.println("Connection Created");
			PreparedStatement pstmt = con.prepareStatement(sqlQuery3);
			pstmt.setString(1,"101");
			pstmt.setClob(2,new FileReader("C:\\NIT\\file1.txt"));
			int rowCount = pstmt.executeUpdate();
			if(rowCount ==0)
			{
				throw new SQLException("please check the code");
			}
			else
			{
				System.out.println("File Inserted");
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	void meth4()
	{
		System.out.println("Reteriving the file from the Database");
		
		try 
		{
			Connection con = connect();
			System.out.println("Database connected Successfully!!!\n");
			PreparedStatement pstmt = con.prepareStatement(sqlQuery4);
			pstmt.setString(1,"101");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				Clob clob = rs.getClob(1);
				Reader data = clob.getCharacterStream();
				BufferedReader br = new BufferedReader(data);
				FileWriter fw = new FileWriter("C:\\NIT\\file2.txt");
				String line;
				while((line=br.readLine()) != null)
				{
					fw.write(line);
				}
				br.close();
				fw.close();
				System.out.println("Clob data Reterived");
			}
			else
			{
				throw new SQLException("Invalid Id");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		JdbcPro15FileImageStore obj = new JdbcPro15FileImageStore();
//		obj.meth1();
//		obj.meth2();
//		obj.meth3();
		obj.meth4();
	}
}

package com.pack1;


/*
 * SQL> create table registration(username varchar2(25) primary key,password  varchar2(25),firstname varchar2(25),lastname varchar2(25),mailid varchar2(25),phone  varchar2(10));

Table created.
 */

public interface DBInfo 
{
	public static final String dburl ="jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String dbname ="soham";
	public static final String dbpwd = "123";
}

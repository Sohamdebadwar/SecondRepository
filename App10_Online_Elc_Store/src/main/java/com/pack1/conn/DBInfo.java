package com.pack1.conn;

/** 
 * 
 SQL> CREATE TABLE ADMIN1 (UNAME VARCHAR2(25) PRIMARY KEY,PWORD  VARCHAR2(25),FNAME VARCHAR2(25),LNAME VARCHAR2(25),ADDR VARCHAR2(25),MID VARCHAR2(25),PHNO VARCHAR2(25));

Table created.

SQL> INSERT INTO ADMIN1 values ('admin','nit','soham','debadwar','hyd','soham@gmail.com','7058846069');

SQL> CREATE TABLE CUSTOMER1 (UNAME  VARCHAR2(25) PRIMARY KEY,PWORD VARCHAR2(25),FNAME VARCHAR2(25),LNAME VARCHAR2(25),ADDR VARCHAR2(25),MID VARCHAR2(25),PHNO VARCHAR2(25));

Table created.

SQL> CREATE TABLE PRODUCT1 (PCODE VARCHAR2(25) PRIMARY KEY,PNAME VARCHAR2(25),PCOMPANY VARCHAR2(25),PPRICE VARCHAR2(25),PQTY VARCHAR2(25));

Table created.
 */

public interface DBInfo 
{
	public static final String dburl ="jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String dbname ="soham";
	public static final String dbpwd = "123";
}


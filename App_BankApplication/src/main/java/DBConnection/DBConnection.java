package DBConnection;

/*
 * CREATE TABLE BANK_USERS (
    USER_ID         NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    FULL_NAME       VARCHAR2(100)   NOT NULL,
    EMAIL           VARCHAR2(100)   NOT NULL,
    USERNAME        VARCHAR2(50)    NOT NULL,
    PASSWORD        VARCHAR2(100)   NOT NULL,
    PHONE_NUMBER    VARCHAR2(15),
    ACCOUNT_NUMBER  VARCHAR2(20),
    BALANCE         NUMBER(12,2),
    CREATED_AT      DATE DEFAULT SYSDATE
);


-------------------------

CREATE TABLE BANK_TRANSACTIONS (
    TXN_ID           NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    SENDER_ACCOUNT   VARCHAR2(20),
    RECEIVER_ACCOUNT VARCHAR2(20),
    AMOUNT           NUMBER(12,2),
    TXN_TYPE         VARCHAR2(20),
    DESCRIPTION      VARCHAR2(200),
    STATUS           VARCHAR2(20),
    TXN_DATE         DATE DEFAULT SYSDATE
);


-------------------------


SQL> CREATE TABLE LOANS (
  2      LOAN_ID     NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  3      CUSTOMER_ID NUMBER NOT NULL,
  4      LOAN_TYPE   VARCHAR2(100),
  5      AMOUNT      NUMBER(12,2),
  6      DURATION    NUMBER,
  7      STATUS      VARCHAR2(20),
  8      APPLY_DATE  DATE DEFAULT SYSDATE,
  9      CONSTRAINT FK_LOANS_CUSTOMER FOREIGN KEY (CUSTOMER_ID)
 10          REFERENCES BANK_USERS(USER_ID)
 11  );

Table created.

 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
		private static Connection conn;//Has a RealtionShip
		public static Connection getConnection() 
		{
			try {
				 try {
					Class.forName("oracle.jdbc.OracleDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","soham","123");
				System.out.println(conn+" ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
			
		}
		
		
}

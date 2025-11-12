package com.pack1;

import java.io.Serializable;

public class UserBean implements Serializable 
{
	private String uName,uPwd,uFname,uLname,uMail,uPhon;
	
	public UserBean()
	{
		
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getuFname() {
		return uFname;
	}

	public void setuFname(String uFname) {
		this.uFname = uFname;
	}

	public String getuLname() {
		return uLname;
	}

	public void setuLname(String uLname) {
		this.uLname = uLname;
	}

	public String getuMail() {
		return uMail;
	}

	public void setuMail(String uMail) {
		this.uMail = uMail;
	}

	public String getuPhon() {
		return uPhon;
	}

	public void setuPnno(String uPhon) {
		this.uPhon = uPhon;
	}
	
	
}

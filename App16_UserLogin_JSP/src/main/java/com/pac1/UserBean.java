package com.pac1;

import java.io.Serializable;

public class UserBean implements Serializable
{
	private String userName,userMail,userMob;

	

	public String getUserMail() {
		return userMail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}
	
	
}

package com.pack1.UserBean;

import java.io.Serializable;

public class UserBean implements Serializable
{

	private String u_name,u_pwd;

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	
	
}

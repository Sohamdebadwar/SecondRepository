package com.pack1;

import java.io.Serializable;

public class EmployeeBean implements Serializable 
{
	private String id,name;
	private String adharNo;
	
	public EmployeeBean()
	{
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	
	
	
	
}

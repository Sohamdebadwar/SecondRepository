package com.pack3.CustomerBean;

import java.io.Serializable;

public class CustomerBean implements Serializable 
{
	 private String uname, pwd, fname, lname, address, mail, mobile;

	 public String getUname() {
		 return uname;
	 }

	 public void setUname(String uname) {
		 this.uname = uname;
	 }

	 public String getPwd() {
		 return pwd;	
	 }

	 public void setPwd(String pwd) {
		 this.pwd = pwd;
	 }

	 public String getFname() {
		 return fname;
	 }

	 public void setFname(String fname) {
		 this.fname = fname;
	 }

	 public String getLname() {
		 return lname;
	 }

	 public void setLname(String lname) {
		 this.lname = lname;
	 }

	 public String getAddress() {
		 return address;
	 }

	 public void setAddress(String address) {
		 this.address = address;
	 }

	 public String getMail() {
		 return mail;
	 }

	 public void setMail(String mail) {
		 this.mail = mail;
	 }

	 public String getMobile() {
		 return mobile;
	 }

	 public void setMobile(String mobile) {
		 this.mobile = mobile;
	 }
	 
	 
}

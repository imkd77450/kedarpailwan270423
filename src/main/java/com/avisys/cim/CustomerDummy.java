package com.avisys.cim;

public class CustomerDummy {

	String fname,lname,mnumber;

	
	public CustomerDummy(String fname, String lname, String mnumber) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mnumber = mnumber;
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


	public String getMnumber() {
		return mnumber;
	}


	public void setMnumber(String mnumber) {
		this.mnumber = mnumber;
	}
	
	
	
	
}

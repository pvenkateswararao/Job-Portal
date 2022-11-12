package com.job.portal.jobPortal.Entity;


public class Login {
	
	long id;
	
	String password;

	public Login() {
		
	}

	public Login(long id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

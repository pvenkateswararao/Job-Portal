package com.job.portal.jobPortal.ExceptionHandler;


public class ErrorDetails {


	private String errorcode;
	private String message;
	
	public ErrorDetails() {
		
	}

	public ErrorDetails(String errorcode, String message) {
		super();
		this.errorcode = errorcode;
		this.message = message;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}



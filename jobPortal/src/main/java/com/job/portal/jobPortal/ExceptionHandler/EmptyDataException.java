package com.job.portal.jobPortal.ExceptionHandler;

import org.springframework.stereotype.Component;

@Component
public class EmptyDataException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public String errorCode;
	public String errorMessage;
	
	public EmptyDataException() {
		
	}
	
	public EmptyDataException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

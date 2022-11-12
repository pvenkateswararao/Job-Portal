package com.job.portal.jobPortal.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> globleExcpetionHandler(IdNotFoundException ex) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getErrorCode(),ex.getErrorMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyDataException.class)
	public ResponseEntity<?> globleExcpetionHandler(EmptyDataException ex) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getErrorCode(),ex.getErrorMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.OK);
	}
	
	
}




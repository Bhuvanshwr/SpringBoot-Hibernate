package com.springrest.hibernate.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

@ExceptionHandler
public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exe)
{
	EmployeeErrorResponse error=new EmployeeErrorResponse();
	
	error.setStatus(HttpStatus.BAD_REQUEST.value());
	error.setMessage(exe.getMessage());
	error.setTimestamp(System.currentTimeMillis());
		
	return new ResponseEntity<EmployeeErrorResponse>(error,HttpStatus.BAD_REQUEST);	
}	



@ExceptionHandler
public ResponseEntity<EmployeeErrorResponse> handleException(Exception exe)
{
	EmployeeErrorResponse error=new EmployeeErrorResponse();
	
	error.setStatus(HttpStatus.BAD_REQUEST.value());
	error.setMessage(exe.getMessage());
	error.setTimestamp(System.currentTimeMillis());
		
	return new ResponseEntity<EmployeeErrorResponse>(error,HttpStatus.BAD_REQUEST);	
}	
}

package com.rest.resource.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.SERVICE_UNAVAILABLE ,reason="Student Id does not exist in back end")
public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;

	public StudentNotFoundException(String message, String errorCode) {
		super(message);
		this.setErrorCode(errorCode);
	}
	public StudentNotFoundException(String message) {
		super(message);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}

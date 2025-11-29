package com.test.exception;

public class DuplicateEmailException extends RuntimeException{
	
	private String message;

	public DuplicateEmailException(String message) {
		super(message);
		//this.message = message;
	}
	
	

}

package com.project.insurance.exception;

public class DuplicateProductNameException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateProductNameException() {
		super();
	}
	
	public DuplicateProductNameException(String message) {
		super(message);
	}
	
	public DuplicateProductNameException(String message, Throwable th) {
		super(message, th);
	}
}

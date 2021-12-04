package com.project.insurance.exception;

public class DuplicateClientIdException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateClientIdException() {
		super();
	}
	
	public DuplicateClientIdException(String message) {
		super(message);
	}
	
	public DuplicateClientIdException(String message, Throwable th) {
		super(message, th);
	}
}

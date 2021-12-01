package com.project.insurance.exception;

public class AccidentDataAccessException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AccidentDataAccessException() {
		super();
	}
	
	public AccidentDataAccessException(String message) {
		super(message);
	}
	
	public AccidentDataAccessException(String message, Throwable th) {
		super(message, th);
	}
}

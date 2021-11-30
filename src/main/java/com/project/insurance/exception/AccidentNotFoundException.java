package com.project.insurance.exception;

public class AccidentNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AccidentNotFoundException() {
		super();
	}
	
	public AccidentNotFoundException(String message) {
		super(message);
	}

	public AccidentNotFoundException(String message, Throwable th) {
		super(message, th);
	}

}

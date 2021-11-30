package com.project.insurance.exception;

public class ClientNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ClientNotFoundException() {
		super();
	}
	
	public ClientNotFoundException(String message) {
		super(message);
	}
	
	public ClientNotFoundException(String message, Throwable th) {
		super(message, th);
	}

}

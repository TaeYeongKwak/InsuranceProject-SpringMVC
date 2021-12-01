package com.project.insurance.exception;

public class ClientDataAccessException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ClientDataAccessException() {
		super();
	}
	
	public ClientDataAccessException(String message) {
		super(message);
	}
	
	public ClientDataAccessException(String message, Throwable th) {
		super(message, th);
	}

}

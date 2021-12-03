package com.project.insurance.exception;

public class ClientSessionExpiredException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ClientSessionExpiredException() {
		super();
	}
	
	public ClientSessionExpiredException(String message) {
		super(message);
	}
	
	public ClientSessionExpiredException(String message, Throwable th) {
		super(message, th);
	}

}

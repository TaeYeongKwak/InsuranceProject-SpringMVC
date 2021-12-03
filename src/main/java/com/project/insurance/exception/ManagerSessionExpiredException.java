package com.project.insurance.exception;

public class ManagerSessionExpiredException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ManagerSessionExpiredException() {
		super();
	}
	
	public ManagerSessionExpiredException(String message) {
		super(message);
	}
	
	public ManagerSessionExpiredException(String message, Throwable th) {
		super(message, th);
	}

	
}

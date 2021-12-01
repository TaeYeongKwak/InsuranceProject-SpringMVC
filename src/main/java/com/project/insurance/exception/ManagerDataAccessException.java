package com.project.insurance.exception;

public class ManagerDataAccessException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ManagerDataAccessException() {
		super();
	}
	
	public ManagerDataAccessException(String message) {
		super(message);
	}
	
	public ManagerDataAccessException(String message, Throwable th) {
		super(message, th);
	}

}

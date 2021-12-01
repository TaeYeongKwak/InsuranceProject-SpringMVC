package com.project.insurance.exception;

public class InsuranceDataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsuranceDataAccessException() {
		super();
	}
	
	public InsuranceDataAccessException(String message) {
		super(message);
	}
	
	public InsuranceDataAccessException(String message, Throwable th) {
		super(message, th);
	}
	
}

package com.project.insurance.exception;

public class InsuranceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InsuranceNotFoundException() {
		super();
	}
	
	public InsuranceNotFoundException(String message) {
		super(message);
	}
	
	public InsuranceNotFoundException(String message, Throwable th) {
		super(message, th);
	}

}
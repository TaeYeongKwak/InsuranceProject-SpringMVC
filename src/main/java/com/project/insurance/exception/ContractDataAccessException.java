package com.project.insurance.exception;

public class ContractDataAccessException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ContractDataAccessException() {
		super();
	}
	
	public ContractDataAccessException(String message) {
		super(message);
	}
	
	public ContractDataAccessException(String message, Throwable th) {
		super(message, th);
	}
	
}

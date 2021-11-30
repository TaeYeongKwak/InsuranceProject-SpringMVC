package com.project.insurance.exception;

public class ContractNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ContractNotFoundException() {
		super();
	}
	
	public ContractNotFoundException(String message) {
		super(message);
	}
	
	public ContractNotFoundException(String message, Throwable th) {
		super(message, th);
	}
}
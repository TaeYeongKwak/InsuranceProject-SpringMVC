package com.project.insurance.exception;

public class DuplicateContractException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DuplicateContractException() {
		super();
	}
	
	public DuplicateContractException(String message) {
		super(message);
	}
	
	public DuplicateContractException(String message, Throwable th) {
		super(message, th);
	}

}

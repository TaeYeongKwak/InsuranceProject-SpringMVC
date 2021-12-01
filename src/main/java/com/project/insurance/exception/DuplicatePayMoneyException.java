package com.project.insurance.exception;

public class DuplicatePayMoneyException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DuplicatePayMoneyException() {
		super();
	}
	
	public DuplicatePayMoneyException(String message) {
		super(message);
	}
	
	public DuplicatePayMoneyException(String message, Throwable th) {
		super(message, th);
	}

}

package com.project.insurance.exception;

public class DuplicateManagerIdException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DuplicateManagerIdException() {
		super();
	}
	
	public DuplicateManagerIdException(String message) {
		super(message);
	}
	
	public DuplicateManagerIdException(String message, Throwable th) {
		super(message, th);
	}

}

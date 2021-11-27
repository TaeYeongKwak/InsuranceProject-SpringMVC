package com.project.insurance.exception;

public class MedicalHistoryNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public MedicalHistoryNotFoundException() {
		super();
	}
	
	public MedicalHistoryNotFoundException(String message) {
		super(message);
	}

	public MedicalHistoryNotFoundException(String message, Throwable th) {
		super(message, th);
	}

}
package com.project.insurance.exception;

public class ManagerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ManagerNotFoundException() {
		super();
	}

	public ManagerNotFoundException(String message) {
		super(message);
	}

	public ManagerNotFoundException(String message, Throwable th) {
		super(message, th);
	}
}

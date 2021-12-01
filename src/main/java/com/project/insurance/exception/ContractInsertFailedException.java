package com.project.insurance.exception;

public class ContractInsertFailedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ContractInsertFailedException(Throwable th) {
		super(th);
	}

}

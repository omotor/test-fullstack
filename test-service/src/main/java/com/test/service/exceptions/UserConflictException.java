package com.test.service.exceptions;

public class UserConflictException extends UserException {

	private static final long serialVersionUID = 5958156995376167181L;

	public UserConflictException() {
		super();
	}

	public UserConflictException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserConflictException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserConflictException(String message) {
		super(message);
	}

	public UserConflictException(Throwable cause) {
		super(cause);
	}

}

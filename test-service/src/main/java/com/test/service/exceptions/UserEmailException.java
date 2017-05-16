package com.test.service.exceptions;

public class UserEmailException extends UserException {

	private static final long serialVersionUID = -6714107625278625315L;

	public UserEmailException() {
		super();
	}

	public UserEmailException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UserEmailException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserEmailException(String arg0) {
		super(arg0);
	}

	public UserEmailException(Throwable arg0) {
		super(arg0);
	}
	
}

package com.test.service.exceptions;

public class UserPhoneException extends UserException {

	private static final long serialVersionUID = -6714107625278625315L;

	public UserPhoneException() {
		super();
	}

	public UserPhoneException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UserPhoneException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserPhoneException(String arg0) {
		super(arg0);
	}

	public UserPhoneException(Throwable arg0) {
		super(arg0);
	}
	
}

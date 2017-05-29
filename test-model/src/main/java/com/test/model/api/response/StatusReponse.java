/*
 * Product: OMotor
 * Copyright (C) 2017 OMotor. All Rights Reserved.
 */
package com.test.model.api.response;

import java.io.Serializable;

/**
 * Pojo de resposta de status.
 * @author esdrastavares
 *
 */
public class StatusReponse implements Serializable {
	
	private static final long serialVersionUID = -3729341532479962344L;
	
	private boolean success = true;

	public boolean isSuccess() {
		return success;
	}

	public String message;

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StatusReponse [success=" + success + "]";
	}

}

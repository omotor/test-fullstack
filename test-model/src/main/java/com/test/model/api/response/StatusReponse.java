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

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "StatusReponse [success=" + success + "]";
	}

}

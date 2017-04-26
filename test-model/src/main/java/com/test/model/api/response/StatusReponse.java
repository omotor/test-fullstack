/*
 * Product: OMotor
 * Copyright (C) 2017 OMotor. All Rights Reserved.
 */
package com.test.model.api.response;

import com.test.model.api.model.User;

import java.io.Serializable;

/**
 * Pojo de resposta de status.
 * @author esdrastavares
 *
 */
public class StatusReponse implements Serializable {
	
	private static final long serialVersionUID = -3729341532479962344L;
	
	private boolean success = true;

	private StatusEnum statusEnum;

	private User user = new User();

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public StatusEnum getStatusEnum() {
		return statusEnum;
	}

	public void setStatusEnum(StatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "StatusReponse [success=" + success + "]";
	}

}

package com.test.model.api.response;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

public class ApiErrorResponse implements Serializable{
	private static final long serialVersionUID = -3729341532479917344L;
	
	private String status;
    private String message;
    private Collection<String> errors;
    
	public ApiErrorResponse(String status, String message, Collection<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
 
    public ApiErrorResponse(String status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
    
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Collection<String> getErrors() {
		return errors;
	}

 	public void setErrors(Collection<String> errors) {
		this.errors = errors;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
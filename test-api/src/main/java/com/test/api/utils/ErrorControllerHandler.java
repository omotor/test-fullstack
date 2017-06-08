package com.test.api.utils;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.model.api.response.ApiErrorResponse;

@ControllerAdvice
public class ErrorControllerHandler  extends ResponseEntityExceptionHandler{
	
	@Inject
	MessageSource messageSource;
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
        MethodArgumentTypeMismatchException ex, WebRequest request) {
		
		return new ResponseEntity<Object>(new ApiErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(),
				this.messageSource.getMessage("restapi.mismatchexception",null, Locale.US), ex.getMessage()),HttpStatus.BAD_REQUEST);
    }
}

package com.test.api.utils;

import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
import com.test.model.api.response.ApiErrorResponse;


@Component
public class ErrorValidationHandler {
	private final static Logger LOGGER = LoggerFactory.getLogger(ErrorValidationHandler.class);
	
	@Inject    
	private MessageSource messageSource;

	public ResponseEntity<ApiErrorResponse> getApiErrorResponse(Errors errors, HttpStatus status){
		LOGGER.debug("Constraint violation");
		Stream<String> messageStream = errors.getAllErrors().stream().map(e -> this.getMessage(e.getDefaultMessage()));
		return new ResponseEntity<ApiErrorResponse>(new ApiErrorResponse(status.getReasonPhrase(),
				this.getMessage("validation.user.errormessage"), messageStream.collect(Collectors.toList())), status);
	}
	
	public String getMessage(String keyError){
		return this.messageSource.getMessage(keyError, null, Locale.ENGLISH);
	}
}

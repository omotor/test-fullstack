package com.test.api.user;

import java.net.URI;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import com.test.api.utils.ErrorValidationHandler;
import com.test.model.api.response.User;
import com.test.service.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
public class UserResource {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserResource.class); 
	 
	@Inject 
	UserService userService;
	
	@Inject
	ErrorValidationHandler errorValidationHandler;
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId) {
		LOGGER.debug("User GET request.");
		
		User user = this.userService.findById(userId);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<User>> getUsers() {
		LOGGER.debug("Users GET request.");
		Iterable<User> users = this.userService.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody User newUser, Errors validationErrors) {
		LOGGER.debug("User POST request.");
		if(validationErrors.hasErrors())
			return this.errorValidationHandler.getApiErrorResponse(validationErrors, HttpStatus.BAD_REQUEST);
			
		//LOGGER.debug(this.messageSource.getMessage("validation.user.email.Pattern", null, Locale.US));
		User createdUser = this.userService.save(newUser);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@Valid @RequestBody User user, Errors validationErrors) {
		LOGGER.debug("User POST request.");
		if(validationErrors.hasErrors())
			return this.errorValidationHandler.getApiErrorResponse(validationErrors, HttpStatus.BAD_REQUEST);
		
		User userUpdated = this.userService.save(user);
		return ResponseEntity.ok().body(userUpdated);
	}
	
	
	
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long userId) {
		LOGGER.debug("User DELETE request.");
		
		this.userService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
}

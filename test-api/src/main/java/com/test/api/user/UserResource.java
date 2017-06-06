package com.test.api.user;

import java.util.Collection;
import java.util.Optional;

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
	//To handle response when there are validation fields errors
	ErrorValidationHandler errorValidationHandler;
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId) {
		LOGGER.debug("User GET request.");
		
		Optional<User> user = this.userService.findById(userId);
		return user.isPresent() ? ResponseEntity.ok().body(user.get()) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<Iterable<User>> getUsers() {
		LOGGER.debug("Users GET request.");
		Collection<User> users = this.userService.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody User newUser, Errors validationErrors) {
		LOGGER.debug("User POST request.");
		if(validationErrors.hasErrors())
			return this.errorValidationHandler.getApiErrorResponse(validationErrors, HttpStatus.BAD_REQUEST);
			
		Optional<User> createdUser = this.userService.create(newUser);
		
		return !createdUser.isPresent() ? ResponseEntity.noContent().build() :
					ResponseEntity.created(ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")
						.buildAndExpand(createdUser.get().getId())
						.toUri()).build();
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable Long userId, @Valid @RequestBody User user, Errors validationErrors) {
		LOGGER.debug("User PUT request.");
		if(validationErrors.hasErrors())
			return this.errorValidationHandler.getApiErrorResponse(validationErrors, HttpStatus.BAD_REQUEST);
		
		Optional<User> userUpdated = this.userService.update(userId, user);
		return userUpdated.isPresent() ? ResponseEntity.ok().body(userUpdated) : ResponseEntity.notFound().build() ;
	}
	
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long userId) {
		LOGGER.debug("User DELETE request.");
		
		this.userService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
}

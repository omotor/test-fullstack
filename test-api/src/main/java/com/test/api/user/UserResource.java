package com.test.api.user;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.entity.UserEntity;
import com.test.service.UserService;
import com.test.service.exceptions.UserConflictException;
import com.test.service.exceptions.UserEmailException;
import com.test.service.exceptions.UserPhoneException;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserResource {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<UserEntity> post(@RequestBody UserEntity request) {
		LOGGER.debug("Save user request.");

		UserEntity result = null;
		
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			result = service.create(request);
		} catch (UserConflictException e) {
			status = HttpStatus.CONFLICT;
		} catch (UserEmailException | UserPhoneException e) {
			status = HttpStatus.BAD_REQUEST;
		}
 
        return new ResponseEntity<UserEntity>(result, status);
	}

	@GetMapping
	public ResponseEntity<Collection<UserEntity>> list() {
		LOGGER.debug("List users.");
		Collection<UserEntity> list = service.all();

		if (list.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Collection<UserEntity>>(list, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<UserEntity> find(@PathVariable("id") Long id) {
		LOGGER.debug("Get user by id {}", id);
		UserEntity user = service.find(id);
        
		if (null == user)  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
        return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<UserEntity> delete(@PathVariable("id") Long id) {
		LOGGER.debug("Delete user by id {}", id);
		
		if(!service.hasUser(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		service.delete(id);
		
		return new ResponseEntity<UserEntity>(HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<UserEntity> update(@RequestBody UserEntity request) {
		LOGGER.debug("Updating user {}", request);
		
		if(!service.hasUser(request.getId())){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		UserEntity updated = service.update(request);
		
		return new ResponseEntity<UserEntity>(updated, HttpStatus.OK);
		
	}

}

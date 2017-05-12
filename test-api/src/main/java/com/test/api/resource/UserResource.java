package com.test.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.User;
import com.test.service.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserResource {

	//private final static Logger LOGGER = LoggerFactory.getLogger(ClientResource.class);
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") Long id) {
		User user = service.getById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {
		List<User> users = service.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User user){
		this.service.save(user);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user){
		this.service.update(user);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		this.service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}

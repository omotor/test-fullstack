package com.test.api.user;

import com.test.model.api.User;
import com.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alexcosta on 27/05/17.
 */
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserResource {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name = "id")  Long id) {
        return ResponseEntity.ok(this.userService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(this.userService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(name = "id")  Long id, @RequestBody User user) {
        this.userService.update(id, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id")  Long id) {
        this.userService.remove(this.userService.get(id));
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        this.userService.saveOrUpdate(user);
        return ResponseEntity.ok(user);
    }
}

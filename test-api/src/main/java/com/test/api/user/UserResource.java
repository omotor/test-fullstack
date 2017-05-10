package com.test.api.user;

import com.test.model.api.UserTest;
import com.test.service.api.user.UserService;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserResource {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    @Inject
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserTest>> getUsers() {
        LOGGER.info("listar");
        return ResponseEntity.ok().body(userService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTest> getUserBy(@PathVariable long id) {
        return ResponseEntity.ok().body(userService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<UserTest> setUser(@Valid @RequestBody UserTest user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(userService.persist(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserTest> setUser(@Valid @RequestBody UserTest user, @PathVariable long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        user.setId(id);
        return ResponseEntity.ok().body(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeUser(@PathVariable long id) {
        UserTest user = new UserTest();
        user.setId(id);
        userService.delete(user);
        return ResponseEntity.ok().build();
    }

}

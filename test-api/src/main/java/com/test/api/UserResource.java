package com.test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.User;
import com.test.service.UserService;

@RestController
@RequestMapping(value = "api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getByID(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public User update(@PathVariable Long id, @RequestBody User request) {
        User updated = userService.getByID(id);

        updated.setNome(request.getNome());
        updated.setEmail(request.getEmail());
        updated.setTelefone(request.getTelefone());
        updated.setSexo(request.getSexo());
        
        return userService.save(updated);
    }

}
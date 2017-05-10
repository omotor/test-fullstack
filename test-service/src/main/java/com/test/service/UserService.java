package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.User;
import com.test.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Iterable<User> getAll() {
        return repository.findAll();
    }

    public User getByID(Long id) {
        return repository.findOne(id);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}

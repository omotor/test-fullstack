package com.test.service;

import java.util.Collection;
import java.util.Optional;


import com.test.model.api.response.User;

public interface UserService {
	Optional<User> findById(Long userId);
	Collection<User> findAll();
	Optional<User> create(User user);
	Optional<User> update(Long userId, User user);
	void deleteById(Long userId);
}

package com.test.service;

import com.test.model.api.response.User;

public interface UserService {
	User findById(Long userId);
	Iterable<User> findAll();
	User save(User user);
	void deleteById(Long userId);
}

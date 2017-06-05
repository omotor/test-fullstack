package com.test.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.test.model.api.response.User;
import com.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Inject
	UserRepository userRepository;
	
	@Override
	public User findById(Long userId) {
		return this.userRepository.findOne(userId);
	}

	@Override
	public Iterable<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public void deleteById(Long userId) {
		this.userRepository.delete(userId);
	}
}

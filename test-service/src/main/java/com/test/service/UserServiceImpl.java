package com.test.service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.api.response.User;
import com.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Inject
	UserRepository userRepository;
	
	@Override
	public Optional<User> findById(Long userId) {
		return this.userRepository.findOne(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<User> findAll() {
		return this.userRepository.findAllUsers().collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Optional<User> create(User user) {
		return this.userRepository.save(user);
	}
	


	@Override
	@Transactional
	public void deleteById(Long userId) {
		this.userRepository.delete(userId);
	}

	@Override
	public Optional<User> update(Long userId, User user) {
		Optional<User> userUpdate = this.findById(userId);
		if(!userUpdate.isPresent())
			return Optional.empty();
		
		userUpdate.ifPresent(u -> {
			u.setName(user.getName());
			u.setEmail(user.getEmail());
			u.setTelephone(user.getTelephone());
			u.setSex(user.getSex());
		});
		
		return this.userRepository.save(userUpdate.get());
	}
}

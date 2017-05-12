package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.User;
import com.test.repository.UserRepository;

@Service
public class UserService implements BaseService<User,Long>{

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return this.repository.findAll();
	}

	@Override
	public User getById(Long id) {
		return this.repository.findOne(id);
	}

	@Override
	public void save(User entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		this.repository.delete(id);
	}

	public void update(User client) {
		this.repository.save(client);
	}

}

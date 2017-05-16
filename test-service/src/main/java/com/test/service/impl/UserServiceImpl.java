package com.test.service.impl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.entity.UserEntity;
import com.test.service.UserService;
import com.test.service.exceptions.UserConflictException;
import com.test.service.exceptions.UserEmailException;
import com.test.service.exceptions.UserPhoneException;
import com.test.service.helper.EmailHelper;
import com.test.service.helper.NumberHelper;
import com.test.service.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository repository;
	
	@Override
	public Collection<UserEntity> all() {
		return Collections.unmodifiableCollection(repository.findAll());
	}

	@Override
	public UserEntity find(Long id) {
		UserEntity entity = repository.findOne(id);
		return entity == null ? null : entity;
		
	}

	@Override
	public void delete(Long id) {
		if(hasUser(id)) repository.delete(id);
		
	}

	@Override
	public boolean hasUser(Long id) {
		return null != repository.findOne(id);
	}

	@Override
	public UserEntity update(UserEntity request) {
		return repository.save(request);
	}

	@Override
	public UserEntity create(UserEntity request) throws UserConflictException, UserEmailException, UserPhoneException {

		if(null == request.getEmail() || !EmailHelper.isEmail(request.getEmail())) throw new UserEmailException("Email invalido!");
		
		if(null == request.getPhone() || !NumberHelper.isNumber(request.getPhone())) throw new UserPhoneException("Email invalido!");
		
		if(repository.hasEmail(request.getEmail())) throw new UserConflictException("Email existente na base de dados");
		
		return repository.save(request);
	}

}

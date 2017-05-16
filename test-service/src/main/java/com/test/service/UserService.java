package com.test.service;

import java.util.Collection;

import com.test.model.entity.UserEntity;
import com.test.service.exceptions.UserConflictException;
import com.test.service.exceptions.UserEmailException;
import com.test.service.exceptions.UserPhoneException;

public interface UserService {

	Collection<UserEntity> all();

	UserEntity find(Long id);

	void delete(Long id);

	boolean hasUser(Long id);

	UserEntity update(UserEntity request);

	UserEntity create(UserEntity request) throws UserConflictException, UserEmailException, UserPhoneException;

}

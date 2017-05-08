package com.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}

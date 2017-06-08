package com.test.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import com.test.model.api.response.User;

@Component
public interface UserRepository extends Repository<User, Long>{
	Optional<User> findOne(Long id);
	
	Optional<User> save(User user);
	
	@Query("select u from User u")
	Stream<User> findAllUsers();
	
	void delete(User user);
	
	void delete(Long userId);
}

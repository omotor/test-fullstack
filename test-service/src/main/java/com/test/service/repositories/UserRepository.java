package com.test.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("SELECT CASE WHEN COUNT(c) >= 1 THEN true ELSE false END FROM UserEntity c WHERE c.email like :email")
	boolean hasEmail(@Param("email") String email);
	
}

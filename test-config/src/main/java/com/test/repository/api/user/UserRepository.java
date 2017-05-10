package com.test.repository.api.user;

import com.test.model.api.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTest, Long>{
    
}

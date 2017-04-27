package com.test.repository;

import com.test.model.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DEK on 24/04/2017.
 */

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
}

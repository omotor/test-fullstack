package com.test.repository;

import com.test.model.api.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Usuário on 26/05/2017.
 */
public interface UserRepository extends JpaRepository<User, Long>{
}

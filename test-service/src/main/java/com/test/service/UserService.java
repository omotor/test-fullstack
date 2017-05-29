package com.test.service;

import com.test.model.api.User;

/**
 * Created by Usuário on 26/05/2017.
 */
public interface UserService extends GenericService<User, Long>{
    void update(Long id, User user);
}

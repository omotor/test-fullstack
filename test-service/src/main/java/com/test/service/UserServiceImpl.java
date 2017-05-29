package com.test.service;

import com.test.model.api.User;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Usuário on 26/05/2017.
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public void update(Long id, User user){
        User userUpdate = this.get(id);
        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPhone(user.getPhone());
        userUpdate.setSex(user.getSex());
        this.update(userUpdate);
    }
}

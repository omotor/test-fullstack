package com.test.service.api.user;

import com.test.model.api.UserTest;
import com.test.repository.api.user.UserRepository;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Inject
    public UserRepository userRepository;

    public List<UserTest> listAll() {
        return userRepository.findAll();
    }

    public UserTest findOne(long id) {
        return userRepository.findOne(id);
    }

    public UserTest persist(UserTest user) {
        user.setId(0);
        return userRepository.save(user);
    }

    public UserTest update(UserTest user) {
        if (user.getId() > 0) {
            user = userRepository.save(user);
        }
        return user;
    }

    public void delete(UserTest user) {
        if (user.getId() > 0) {
            userRepository.delete(user.getId());
        }
    }

}

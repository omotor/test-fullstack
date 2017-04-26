package com.test.api.endpoint;

import com.test.api.status.StatusResource;
import com.test.model.api.model.User;
import com.test.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by DEK on 24/04/2017.
 */

@Controller
@RequestMapping("/api")
public class UserEndpoint {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserEndpoint.class);

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(
            value = "/user",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> viewUsers()
    {
        List<User> users = userRepo.findAll();
        LOGGER.debug(String.format("Found total %s Users",users.size()));
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/user",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        try {
            User newUser = userRepo.save(user);
            return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id)
    {
        User user = userRepo.findOne(id);
        if(user != null){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }else {
            return new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id)
    {
        try {
            userRepo.delete(id);
            return new ResponseEntity<User>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }
}

package com.in28minutes.rest.webservices.restfulwebservices.user.controller;

import com.in28minutes.rest.webservices.restfulwebservices.user.dao.UserDaoService;
import com.in28minutes.rest.webservices.restfulwebservices.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    // retrieve all users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    // retrieve single user
    @GetMapping(path = "/users/{userId}")
    public User retrieveUser(@PathVariable int userId){
        return userDaoService.findUser(userId);
    }

    // create user
    @PostMapping("/user")
    public void createUser(@RequestBody User user){
       User savedUser =  userDaoService.save(user);
    }
}

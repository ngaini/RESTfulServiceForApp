package com.in28minutes.rest.webservices.restfulwebservices.user.controller;

import com.in28minutes.rest.webservices.restfulwebservices.user.Exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.user.dao.UserDaoService;
import com.in28minutes.rest.webservices.restfulwebservices.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = userDaoService.findUser(userId);
        if(user==null)
            throw new UserNotFoundException("id - " + userId);
        return user;
    }

    // create user
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
       User savedUser =  userDaoService.save(user);

       // set the return status as created
       URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

       return ResponseEntity.created(location).build(); // location of created header is sent back in response header
    }
}

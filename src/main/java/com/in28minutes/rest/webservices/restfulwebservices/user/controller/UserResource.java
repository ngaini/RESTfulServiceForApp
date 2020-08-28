package com.in28minutes.rest.webservices.restfulwebservices.user.controller;

import com.in28minutes.rest.webservices.restfulwebservices.user.Exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.user.dao.UserDaoService;
import com.in28minutes.rest.webservices.restfulwebservices.user.entity.User;
import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
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
    public EntityModel<User> retrieveUser(@PathVariable int userId){
        User user = userDaoService.findUser(userId);
        if(user==null)
            throw new UserNotFoundException("id - " + userId);

        //link to all users
        EntityModel<User> resource = EntityModel.of(user);

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers()
        );
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    // create user
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
       User savedUser =  userDaoService.save(user);

       // set the return status as created
       URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

       return ResponseEntity.created(location).build(); // location of created header is sent back in response header
    }

    //delete user
    @DeleteMapping(path="/users/{userId}")
    public void deleteUser(@PathVariable int userId){
        User user = userDaoService.deleteById(userId);
        if(user == null){
            throw new UserNotFoundException(String.format("User with id [userId:%d] not found", userId));
        }
    }
}

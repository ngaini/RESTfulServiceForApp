package com.in28minutes.rest.webservices.restfulwebservices.post.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message){
        super(message);
    }
}

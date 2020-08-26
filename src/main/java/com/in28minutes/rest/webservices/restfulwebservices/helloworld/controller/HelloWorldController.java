package com.in28minutes.rest.webservices.restfulwebservices.helloworld.controller;


import com.in28minutes.rest.webservices.restfulwebservices.helloworld.entity.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/starter-api")
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World! The time is " + new Date();
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World! The time is " + new Date() + "\n It's Bean Time ");
    }

    @GetMapping(path= "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World! The time is %tc \n Welcome to %s", new Date(), name));
    }
}

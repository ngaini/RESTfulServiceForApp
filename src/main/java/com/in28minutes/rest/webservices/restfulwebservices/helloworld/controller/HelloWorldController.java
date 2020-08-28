package com.in28minutes.rest.webservices.restfulwebservices.helloworld.controller;


import com.in28minutes.rest.webservices.restfulwebservices.helloworld.entity.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/greetings")
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloWorld(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        String greeting = messageSource.getMessage("good.morning.message", null, locale);
        return greeting +"! The time is " + new Date();
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World! The time is " + new Date() + "\n It's Bean Time ");
    }

    @GetMapping(path= "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World! The time is %tc \n Welcome to %s", new Date(), name));
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(){
        String greeting = messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
        return greeting +"! The time is " + new Date();
    }
}

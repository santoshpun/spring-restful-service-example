package com.santosh.springrestfulserviceexample.controller;

import com.santosh.springrestfulserviceexample.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "api/example1")
public class Example1Controller {

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome() {
        return "Welcome to RESTful service world !!";
    }

    @RequestMapping(value = "users/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public User saveUser(@RequestBody User userRequest) {
        log.info("User saved successfully...");
        //add some logic to save user to database
        return userRequest;
    }

    //Path variable with same name
    @RequestMapping(value = "users/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        return new User(userId);
    }

    //Path variable with different name
    @RequestMapping(value = "users/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable(name = "id") int userId) {
        return new User(userId);
    }

    //Path variable as optional
    @RequestMapping(value = {"userInfo","userInfo/{userId}"}, method = RequestMethod.GET)
    public User getUserObj(@PathVariable(name = "userId", required = false) Integer userId) {
        log.info("User id : " + userId);
        if (userId != null) {
            return new User(userId);
        } else {
            return new User(0);
        }
    }

    @RequestMapping(value = "greet/name", method = RequestMethod.GET)
    public String getName(@RequestParam(name = "name") String name) {
        return "Welcome, " + name;
    }

    @RequestMapping(value = "greet2/name", method = RequestMethod.GET)
    public String getName2(@RequestParam(defaultValue = "Santosh") String name) {
        return "Welcome, " + name;
    }

    @RequestMapping(value = "greet3/name", method = RequestMethod.GET)
    public String getName3(@RequestParam(required = false) String name) {
        return "Welcome, " + name;
    }

    @RequestMapping(value = "exception2", method = RequestMethod.GET)
    public User errorMethod2() {
        String name = null;
        //throw nullpointer exception
        name.toUpperCase();
        return new User(1);
    }

    @RequestMapping(value = "exception", method = RequestMethod.GET)
    public String errorMethod() {
        String name = null;
        //throw nullpointer exception
        name.toUpperCase();
        return name;
    }

    @ExceptionHandler(NullPointerException.class)
    String handleNullPointerException(NullPointerException exception) {
        log.error(exception.getMessage());
        return "Null pointer exception";
    }
}


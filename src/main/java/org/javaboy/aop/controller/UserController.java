package org.javaboy.aop.controller;

import org.javaboy.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("test1")
    public String test1(){
        return userService.test1();
    }
    @GetMapping("test2")
    public String test2(){
        return userService.test2();
    }
}

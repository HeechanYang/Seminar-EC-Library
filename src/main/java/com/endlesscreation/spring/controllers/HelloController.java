package com.endlesscreation.spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class HelloController {

    @RequestMapping
    public String hello(){
        return "Hello Spring!";
    }
}

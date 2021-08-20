package com.example.helloservice.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("/")
    public String start() {
        return "Welcome to HELLO-SERVICE!";
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable(name="name") String name) {
        return "Hello " + name;
    }

}

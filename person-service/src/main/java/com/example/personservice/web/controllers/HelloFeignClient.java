package com.example.personservice.web.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="hello")
public interface HelloFeignClient {

    @GetMapping("/{name}")
    String hello(@PathVariable(name="name") String name);
}

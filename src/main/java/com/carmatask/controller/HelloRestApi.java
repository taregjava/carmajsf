package com.carmatask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestApi {

    @GetMapping("/restapi")
    public String hello() {
        return "hello api";
    }
}

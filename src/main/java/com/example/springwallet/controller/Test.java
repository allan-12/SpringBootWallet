package com.example.springwallet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/ping/{name}")
    public String pingPong(@PathVariable String name){
        return "pong"+ name;
    }

}

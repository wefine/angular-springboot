package com.wefine.app.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/api/hi")
    public String hi() {
        return "Hello World from Restful API";
    }
}
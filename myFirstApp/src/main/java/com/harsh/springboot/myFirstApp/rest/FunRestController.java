package com.harsh.springboot.myFirstApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "hello world!";
    }

    @GetMapping("/harsh")
    public String sayHarsh() {
        return "Hello Harsh! from Java ";
    }
}

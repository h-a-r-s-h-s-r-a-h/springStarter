package com.harsh.springboot.myFirstApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${dev.name}")
    private String devName;

    @Value("${dev.age}")
    private String devAge;

    @GetMapping("/")
    public String sayHello() {
        return "hello world!";
    }

    @GetMapping("/harsh")
    public String sayHarsh() {
        return "Hello  " + devName + "! from Java. " + "Your age is " + devAge;
    }

    @GetMapping("/dev")
    public String sayDev() {
        return "Hello Dev! from Java. ";
    }
}

package edu.miu.cs544.group1.project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MyController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping
    public String hello() {
        return "Hello world from " + applicationName;
    }
}

package com.example.vaika.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    @GetMapping("/hello")
    public String direBonjour() {
        return "Bonjour, ceci est un web service Spring Boot!";
    }

}


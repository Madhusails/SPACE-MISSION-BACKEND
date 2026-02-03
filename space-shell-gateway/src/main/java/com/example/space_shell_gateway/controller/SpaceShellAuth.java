package com.example.space_shell_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpaceShellAuth {
    @GetMapping("/test")
    public String test() {
        return "Test endpoint";
    }

    @PostMapping("/add")
    public String postTest() {
        return "Post Test Endpoint";
    }
}

package com.example.space_shell_gateway.controller;

import com.example.space_shell_gateway.dto.UserRequest;
import com.example.space_shell_gateway.entity.Users;
import com.example.space_shell_gateway.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public Users createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }
}

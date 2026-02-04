package com.example.space_shell_gateway.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}

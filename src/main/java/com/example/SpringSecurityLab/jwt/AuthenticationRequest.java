package com.example.SpringSecurityLab.jwt;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;

    // Getters and Setters
}

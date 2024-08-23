package com.example.SpringSecurityLab.controller;


import com.example.SpringSecurityLab.config.CustomUserDetailsService;
import com.example.SpringSecurityLab.jwt.AuthenticationRequest;
import com.example.SpringSecurityLab.jwt.AuthenticationResponse;
import com.example.SpringSecurityLab.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        // Generate JWT token
        String token = jwtUtil.generateToken(authentication.getName());

        return new AuthenticationResponse(token);
    }

    @GetMapping("/home")
    public String home() {
        return "home";  // returns home.html (accessible by all roles)
    }

    @GetMapping("/employee/dashboard")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public String employeeDashboard() {
        return "employee"; // return your employee dashboard view name
    }

    @GetMapping("/manager/dashboard")
    @PreAuthorize("hasRole('MANAGER')")
    public String managerDashboard() {
        return "manager";  // return your manager dashboard view name
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminDashboard() {
        return "admin";  // return your admin dashboard view name
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";  // returns access-denied.html
    }
}

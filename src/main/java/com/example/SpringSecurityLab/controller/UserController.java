//package com.example.SpringSecurityLab.controller;
//
//
//import com.example.SpringSecurityLab.config.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.Map;
//
//@Controller
//public class UserController {
//
//
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//
//    @GetMapping("/home")
//    public String home() {
//        return "home";  // returns home.html (accessible by all roles)
//    }
//
//    @GetMapping("/employee/dashboard")
//    @PreAuthorize("hasRole('EMPLOYEE')")
//    public String employeeDashboard() {
//        return "employee"; // return your employee dashboard view name
//    }
//
//    @GetMapping("/manager/dashboard")
//    @PreAuthorize("hasRole('MANAGER')")
//    public String managerDashboard() {
//        return "manager";  // return your manager dashboard view name
//    }
//
//    @GetMapping("/admin/dashboard")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String adminDashboard() {
//        return "admin";  // return your admin dashboard view name
//    }
//
//    @GetMapping("/access-denied")
//    public String accessDenied() {
//        return "access-denied";  // returns access-denied.html
//    }
//}

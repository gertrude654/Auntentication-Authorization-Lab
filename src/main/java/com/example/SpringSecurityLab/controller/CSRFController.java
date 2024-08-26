package com.example.SpringSecurityLab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CSRFController {

    @GetMapping("/csrf-form")
    public String showCsrfForm() {
        return "CSRF";
    }

    @PostMapping("/submit")
    public String handleSubmit(@RequestParam("someField") String someField, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Form submitted successfully!");
        return "redirect:/csrf-form";
    }
}

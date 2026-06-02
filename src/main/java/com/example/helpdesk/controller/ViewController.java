package com.example.helpdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
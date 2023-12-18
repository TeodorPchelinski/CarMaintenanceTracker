package com.example.carmaintenancetracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CommunityController {

    @GetMapping("/community")
    public String community() {
        return "community";
    }
}

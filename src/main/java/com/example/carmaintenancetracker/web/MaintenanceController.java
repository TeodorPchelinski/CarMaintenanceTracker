package com.example.carmaintenancetracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MaintenanceController {

    @GetMapping("/maintenance")
    public String maintenance() {
        return "maintenance";
    }

    //todo: button to expenses
    @PostMapping("/maintenance")
    public String expenses() {
        return "redirect:/expenses";
    }

}

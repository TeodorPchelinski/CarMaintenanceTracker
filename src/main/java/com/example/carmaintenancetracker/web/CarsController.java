package com.example.carmaintenancetracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @GetMapping("/owned")
    public String userCars() {
        return "my-garage";
    }

    @GetMapping("/all")
    public String allCars() {
        return "all-cars";
    }

}

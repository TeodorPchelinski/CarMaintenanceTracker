package com.example.carmaintenancetracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarsController {

    @GetMapping("/owned-cars")
    public String userCars() {
        return "my-garage";
    }

//    @GetMapping("/all")
//    public String allCars() {
//        return "all-cars-old";
//    }

    @PostMapping("/owned")
    public String addCar() {



        return "my-garage";
    }

}

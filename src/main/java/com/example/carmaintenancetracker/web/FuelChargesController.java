package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.enums.FuelTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuelChargesController {

    @GetMapping("/fuel-tracker")
    public String fuelTracker() {
        return "fuel-tracker";
    }

    @ModelAttribute("fuels")
    public FuelTypeEnum[] fuels() {
        return FuelTypeEnum.values();
    }

    @PostMapping("/fuel-tracker")
    public String addFuel(Model model) {


        return "fuel-tracker";
    }

}

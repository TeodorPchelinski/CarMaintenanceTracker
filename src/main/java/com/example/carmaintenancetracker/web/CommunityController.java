package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.CarSummaryDTO;
import com.example.carmaintenancetracker.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CommunityController {

    private CarService carService;

    public CommunityController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/community")
    public String allCars(Model model,
                          @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        Page<CarSummaryDTO> allCars = carService.getAllCars(pageable);

        model.addAttribute("allCars", allCars);
        return "community";
    }
}

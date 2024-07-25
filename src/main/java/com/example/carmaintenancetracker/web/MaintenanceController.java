package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.CarSummaryDTO;
import com.example.carmaintenancetracker.model.dto.CreateRepairDTO;
import com.example.carmaintenancetracker.model.entity.PartEntity;
import com.example.carmaintenancetracker.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MaintenanceController {

    private final CarService carService;

    private CreateRepairDTO createRepairDTO;

    public MaintenanceController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/maintenance")
    public String maintenance(Model model,
                              @PageableDefault(size = 30,sort = "id") Pageable pageable,
                              @AuthenticationPrincipal UserDetails creator) {

        //todo: Car id and other fields in the Repair Form

        Page<CarSummaryDTO> userCars = carService.getAllCarsByOwnerId(pageable, creator);

        CreateRepairDTO repairForm = new CreateRepairDTO();

        List<PartEntity> parts = new ArrayList<>();

        for(int i = 1; i < 3; i++){
            parts.add(new PartEntity());
        }

        int partsCount = 3;

        repairForm.setParts(parts);


        model.addAttribute("partsCount", partsCount);
        model.addAttribute("createRepairDTO", createRepairDTO);
        model.addAttribute("cars", userCars);
        return "maintenance";
    }


    //todo: button to expenses
    @PostMapping("/maintenance")
    public String expenses() {
        return "redirect:/expenses";
    }



}

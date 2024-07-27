package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.CarSummaryDTO;
import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.dto.CreateRepairDTO;
import com.example.carmaintenancetracker.model.entity.PartEntity;
import com.example.carmaintenancetracker.service.CarService;
import com.example.carmaintenancetracker.service.RepairService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MaintenanceController {

    private final CarService carService;

    private RepairService repairService;
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


//        model.addAttribute("createRepairDTO", createRepairDTO);
        model.addAttribute("cars", userCars);
        return "maintenance";
    }

    @PostMapping("/maintenance")
    public String repair(@Valid @ModelAttribute("createRepairDTO") CreateRepairDTO createRepairDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createRepairDTO", createRepairDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createRepairDTO", bindingResult);



            return "redirect:/maintenance";
        }

        System.out.println("Hello");


        repairService.createRepair(createRepairDTO);
        System.out.println(createRepairDTO);

        return "/maintenance";
    }


    //todo: button to expenses
//    @PostMapping("/maintenance")
//    public String expenses() {
//        return "redirect:/expenses";
//    }



}

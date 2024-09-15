package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.CarSummaryDTO;
import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.dto.CreateRepairDTO;
import com.example.carmaintenancetracker.model.dto.RecentRepairsDTO;
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

    private final RepairService repairService;
    private CreateRepairDTO createRepairDTO;

    public MaintenanceController(CarService carService, RepairService repairService) {
        this.carService = carService;
        this.repairService = repairService;

    }

    @GetMapping("/maintenance")
    public String maintenance(Model model,
                              @PageableDefault(sort = "id") Pageable pageable,
                              @AuthenticationPrincipal UserDetails creator) {

        Page<CarSummaryDTO> userCars2 = carService.getAllCarsByOwnerId(pageable, creator);

        Page<RecentRepairsDTO> recentRepairs = repairService.getAllRepairsByCreatorId(pageable, creator);

        model.addAttribute("cars", userCars2);
        model.addAttribute("repairs", recentRepairs);
        return "maintenance";
    }

    @PostMapping("/maintenance")
    public String repair(@Valid @ModelAttribute("createRepairDTO") CreateRepairDTO createRepairDTO,
                          @AuthenticationPrincipal UserDetails creator) {
//                            BindingResult bindingResult,
//                            RedirectAttributes redirectAttributes

//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("createRepairDTO", createRepairDTO);
//            redirectAttributes.addFlashAttribute(
//                    "org.springframework.validation.BindingResult.createRepairDTO", bindingResult);
//
//
//
//            return "redirect:/maintenance";
//        }


        repairService.createRepair(createRepairDTO, creator);

        return "redirect:/maintenance";
    }


    //todo: button to expenses
//    @PostMapping("/maintenance")
//    public String expenses() {
//        return "redirect:/expenses";
//    }



}

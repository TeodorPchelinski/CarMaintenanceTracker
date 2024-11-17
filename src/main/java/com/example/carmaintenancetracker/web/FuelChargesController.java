package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.CarSummaryDTO;
import com.example.carmaintenancetracker.model.dto.CreateRefuelDTO;
import com.example.carmaintenancetracker.model.enums.FuelTypeEnum;
import com.example.carmaintenancetracker.service.CarService;
import com.example.carmaintenancetracker.service.RefuelService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FuelChargesController {

    private final RefuelService refuelService;
    private final CarService carService;

    public FuelChargesController(RefuelService refuelService, CarService carService) {
        this.refuelService = refuelService;
        this.carService = carService;
    }

    @GetMapping("/fuel-tracker")
    public String fuelTracker(Model model, @PageableDefault(size = 30,sort = "id") Pageable pageable,
                              @AuthenticationPrincipal UserDetails creator) {

        Page<CarSummaryDTO> userCars2 = carService.getAllCarsByOwnerId(pageable, creator);

        model.addAttribute("cars", userCars2);
        return "fuel-tracker";
    }

    @ModelAttribute("fuels")
    public FuelTypeEnum[] fuels() {
        return FuelTypeEnum.values();
    }

    @PostMapping("/fuel-tracker")
    public String addFuel(@Valid @ModelAttribute("createRefuelDTO") CreateRefuelDTO createRefuelDTO,
                          @AuthenticationPrincipal UserDetails creator) {

        System.out.println(createRefuelDTO);
        refuelService.createRefuel(createRefuelDTO, creator);

        return "redirect:/fuel-tracker";
    }

//    @PostMapping("/fuel-tracker")
//    public String addFuel(CreateRefuelDTO createRefuelDTO) {
//        //todo: add user
//        refuelService.createRefuel(createRefuelDTO);
//        return "redirect:/";
//
//    }

}

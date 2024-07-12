package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.CarSummaryDTO;
import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.enums.FuelEnum;
import com.example.carmaintenancetracker.model.enums.TransmissionEnum;
import com.example.carmaintenancetracker.model.enums.VignettePeriodEnum;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.CarService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class CarsController {
    private final CarService carService;
    private final UserRepository userRepository;


//    private final UserDetails creator;

    private CreateCarDTO createCarDTO;


    public CarsController(CarService carService,
                          UserRepository userRepository) {
        this.carService = carService;
        this.userRepository = userRepository;
    }


    @PostMapping("/cars/{id}")
    public String deleteCarById(@PathVariable("id") Long id) {
        carService.deleteCarById(id);
        return "redirect:/cars";
    }

    @GetMapping("/cars")
    public String userCars(Model model,
                           @PageableDefault(size = 16,sort = "id") Pageable pageable,
                           @AuthenticationPrincipal UserDetails creator) {


        Page<CarSummaryDTO> userCars = carService.getAllCarsByOwnerId(pageable, creator);


       model.addAttribute("cars", userCars);
        return "my-garage";
    }


    // Options when creating a car
    @ModelAttribute("engineFuel")
    public FuelEnum[] engineFuel() {
        return FuelEnum.values();
    }

    @ModelAttribute("transmission")
    public TransmissionEnum[] transmission() {
        return TransmissionEnum.values();
    }
    @ModelAttribute("vignettePeriod")
    public VignettePeriodEnum[] vignettePeriod() {
        return VignettePeriodEnum.values();
    }



//    @ModelAttribute("cars")
//    public Page<CarSummaryDTO> getAllCarsByOwnerId(@RequestParam int page, @RequestParam int size, Principal principal){
//
//        // page and size comes from html
//        Pageable pageable = PageRequest.of(page, size);
//
//
//
//        return null;
//    }


    @GetMapping("/cars/add")
    public String addCarForm(Model model){
//        model.addAttribute("createCarDTO", new CreateCarDTO());
        return "car-add";
    }

    @PostMapping("/cars/add")
    public String add(@Valid @ModelAttribute("createCarDTO") CreateCarDTO createCarDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes,
                      @AuthenticationPrincipal UserDetails creator) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createCarDTO", createCarDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createCarDTO", bindingResult);

            return "redirect:/cars";

        }

        carService.createCar(createCarDTO, creator);

        System.out.println(createCarDTO);


        return "redirect:/";

    }

    //todo: Params if I want values to stay after wrong inputs

//    @PostMapping("/create")
//    public String createCar(@RequestParam("brand") String brand,
//                            @RequestParam("model") String model,
//                            @RequestParam("year") String year,
//                            @RequestParam("fuel-type") String fuelType,
//                            @RequestParam("engine-displacement") String engineDisplacement,
//                            @RequestParam("transmission") String transmission) {
//
//        return null;
//    }


    @GetMapping("cars/details/{id}")
    public String details(@PathVariable("id") Long id, Model model ) {


        //todo: don't expose CarEntity to Controller side -> make DTO
        CarEntity carEntity = carService.findCarById(id);
        model.addAttribute("car", carEntity);



        return "car-details";
    }
    // 1:17:00 Spring Essentials

}

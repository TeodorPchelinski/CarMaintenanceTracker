package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.dto.UserCarsDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.CarService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CarsController {
    private final CarService carService;
    private final UserRepository userRepository;

    public CarsController(CarService carService,
                          UserRepository userRepository) {
        this.carService = carService;
        this.userRepository = userRepository;
    }

    @GetMapping("/cars-owned")
    public String userCars() {
        return "my-garage";
    }


    @PostMapping("/cars/add")
    public String add(@Valid CreateCarDTO createCarDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()) {

            return "redirect:/login";
        }


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createCarDTO", createCarDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createCarDTO", bindingResult);

            System.out.println(createCarDTO);

            return "redirect:/cars/add";

        }

        CarEntity newCarId = carService.createCar(createCarDTO);

        return "redirect:/car/" + newCarId;
    }

    @PostMapping("/create")
    public String createCar(@RequestParam("brand") String brand,
                            @RequestParam("model") String model,
                            @RequestParam("year") String year,
                            @RequestParam("fuel-type") String fuelType,
                            @RequestParam("engine-displacement") String engineDisplacement,
                            @RequestParam("transmission") String transmission) {

        return null;
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable("id") Long id) {
        return "car-details";
    }

}

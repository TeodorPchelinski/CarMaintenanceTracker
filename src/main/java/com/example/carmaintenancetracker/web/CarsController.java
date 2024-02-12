package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.CarService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CarsController {
    private final CarService carService;
    private final UserRepository userRepository;


  //  private final UserDetails creator;

    private CreateCarDTO createCarDTO;


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
                      RedirectAttributes redirectAttributes,
                      @AuthenticationPrincipal UserDetails creator) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createCarDTO", createCarDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createCarDTO", bindingResult);

            return "redirect:/cars/add";

        }

        Long newCarId = carService.createCar(createCarDTO, creator);
        System.out.println(newCarId);
//        return "redirect:/car/";
        return "redirect:/car/" + newCarId;

        //todo: Have a problem with UserDetails Right here above. Need fix before making functions
    }

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

    @GetMapping("/{id}/details")
    public String details(@PathVariable("id") Long id) {
        return "car-details";
    }

}

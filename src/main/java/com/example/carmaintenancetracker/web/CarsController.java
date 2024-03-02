package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.enums.FuelEnum;
import com.example.carmaintenancetracker.model.enums.TransmissionEnum;
import com.example.carmaintenancetracker.model.enums.VignettePeriodEnum;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.CarService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/cars")
    public String userCars() {
        return "my-garage";
    }

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


    //todo: Under is the test of CarDTO
//    @PostMapping("/cars/add")
//    public String add(CreateCarDTO createCarDTO) {
//
//
//
//        System.out.println(createCarDTO);
//
//
//        return "redirect:/cars";
//
//    }

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


    @GetMapping("/{id}/details")
    public String details(@PathVariable("id") Long id) {
        return "car-details";
    }
    // 1:17:00 Spring Essentials

}

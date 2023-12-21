package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yaml.snakeyaml.events.Event;

@Controller
public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/owned-cars")
    public String userCars() {
        return "my-garage";
    }


    @PostMapping("/cars/add")
    public String add(@Valid CreateCarDTO createCarDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createCarDTO", createCarDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createCarDTO", bindingResult);

            System.out.println(createCarDTO);

            return "redirect:/cars/add";

        }

        Long newCarId = carService.createCar(createCarDTO);


        return "redirect:/car/" + newCarId;
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable("id") Long id) {
        return "car-details";
    }

}

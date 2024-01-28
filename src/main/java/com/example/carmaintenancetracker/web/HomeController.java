package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.service.CarService;
import com.example.carmaintenancetracker.service.UserService;
import com.example.carmaintenancetracker.service.impl.CarServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final UserService userService;

    private final CarService carService;

    public HomeController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }


    @ModelAttribute
    public UserEntity name(Model model) {




        return new UserEntity().setFirstName("Hand Written Name");
    }

    @GetMapping("/index")
    public String home(@ModelAttribute UserEntity userEntity) {
        return "index";
    }

}

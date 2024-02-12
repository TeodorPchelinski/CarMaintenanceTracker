package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.service.CarService;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public void name(Model model) {
//        String username = userService.getUserByEmail();
//        model.addAttribute("username", new UserEntity().setFirstName(username));
//        System.out.println(username);
    }
    //todo: logic behind getting the name of the user logged

    //todo: logout <input> design make it like the others <li>

    @GetMapping("/index")
    public String home() {
        return "index";
    }

}

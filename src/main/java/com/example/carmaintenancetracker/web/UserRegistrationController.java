package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.UserRegistrationDTO;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {


    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register() {
        //todo: UserDTO

//        UserRegistrationDTO userDto = new UserRegistrationDTO();
//        model.addAttribute("user", userDto);


        return "auth-registration";
    }

    @PostMapping("/users/register")
    public String register(UserRegistrationDTO userRegistrationDTO){

        System.out.println(userRegistrationDTO);
        userService.registerUser(userRegistrationDTO);


        return "redirect:/";
    }

}

package com.example.carmaintenancetracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserRegistrationController {


    @GetMapping("/users/register")
    public String register() {
        //todo: UserDTO
        //(Model model)
        //UserDTO userDto = new UserDTO();
        //model.addAttribute("user", userDto);
        return "auth-registration";
    }

}

package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.dto.UserLoginDTO;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginDTO userLoginDTO) {

        userService.loginUser(userLoginDTO);

        return "redirect:/";

    }

}

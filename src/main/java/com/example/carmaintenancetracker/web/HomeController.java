package com.example.carmaintenancetracker.web;

import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @ModelAttribute
    public UserEntity name(Model model) {
        return new UserEntity().setFirstName("username");
    }

}

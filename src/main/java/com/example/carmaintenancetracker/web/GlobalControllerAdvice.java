package com.example.carmaintenancetracker.web;


import com.example.carmaintenancetracker.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@ControllerAdvice
public class GlobalControllerAdvice {

    private final UserService userService ;

    public GlobalControllerAdvice(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("username")
    public String getUsername(@AuthenticationPrincipal UserDetails username) {

        if (username != null) {
            String userLogged = userService.getUserByEmail(username);
            if (userLogged != null) {
                return userLogged;
            }else{
                return "UserNull";
            }
        }else{
            return "Guest";
        }




        //todo: add logic from UserController for username display
    }

}

package com.example.carmaintenancetracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpensesController {

    @GetMapping("/expenses") //todo: (/carId/expenses)
    public String expenses() {
        return "expenses";
    }

}

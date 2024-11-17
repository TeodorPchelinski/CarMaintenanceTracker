package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.dto.CreateRefuelDTO;
import org.springframework.security.core.userdetails.UserDetails;


public interface RefuelService  {

    void createRefuel(CreateRefuelDTO createRefuelDTO, UserDetails creator);

}

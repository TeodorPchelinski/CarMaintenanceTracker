package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;


public interface CarService {

    Long createCar(CreateCarDTO createCarDTO);
}

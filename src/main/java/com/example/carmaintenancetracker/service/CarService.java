package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.entity.UserEntity;

import java.util.List;


public interface CarService {

    CarEntity createCar(CreateCarDTO createCarDTO);

    List<CarEntity> getCarsByOwner(UserEntity owner);
}

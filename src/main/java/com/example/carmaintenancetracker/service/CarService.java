package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface CarService {

    Long createCar(CreateCarDTO createCarDTO, UserDetails creator);

    List<CarEntity> getCarsByOwner(UserEntity owner);
}

package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.CarService;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final UserRepository userRepository;
    private UserService userService;

    public CarServiceImpl(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public Long createCar(CreateCarDTO createCarDTO) {

        CarEntity newCar = map(createCarDTO, userService);
        return null;
    }

    private CarEntity map(CreateCarDTO createCarDTO, UserService userService) {

        //todo: adding User logged as owner
        return new CarEntity().setBrand(createCarDTO.getBrand())
                .setModel(createCarDTO.getModel())
                .setManufactureYear(createCarDTO.getManufactureYear())
                .setBought(createCarDTO.getBought())
                .setMileage(createCarDTO.getMileage())
                .setFuelType(createCarDTO.getFuelEngineType());
    }
}

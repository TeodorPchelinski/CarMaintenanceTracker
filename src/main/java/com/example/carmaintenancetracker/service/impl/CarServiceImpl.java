package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.repository.CarRepository;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.CarService;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final UserRepository userRepository;
    private UserService userService;
    private final CarRepository carRepository;


    public CarServiceImpl(UserRepository userRepository, UserService userService,
                          CarRepository carRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.carRepository = carRepository;
    }


    @Override
    public Long createCar(CreateCarDTO createCarDTO, UserDetails creator) {

        // not logged user can't create car because he won't be allowed to be on Create Car page or My Garage page
        //todo: loggedUser = email of the user -> we need user's first and last name


        CarEntity newCar = map(createCarDTO);

        UserEntity ownerEntity = userRepository.findByEmail(creator.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User with email " + creator.getUsername() + "not found!"));

        newCar.setOwner(ownerEntity);

        newCar = carRepository.save(newCar);

        return newCar.getId();
    }

    private CarEntity map(CreateCarDTO createCarDTO) {

        CarEntity newCar = new CarEntity()
                .setModel(createCarDTO.getModel())
                .setBrand(createCarDTO.getBrand())
                .setManufactureYear(createCarDTO.getManufactureYear())
                .setFuelType(createCarDTO.getFuelEngineType())
                .setEngineDisplacement(createCarDTO.getEngineDisplacement())
                .setTransmission( createCarDTO.getTransmission());

         return newCar;
    }

    @Override
    public List<CarEntity> getCarsByOwner(UserEntity owner) {
        return carRepository.findAllByOwner(owner);
    }
}

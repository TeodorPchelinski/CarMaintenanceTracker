package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CreateRefuelDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.entity.RefuelEntity;
import com.example.carmaintenancetracker.repository.CarRepository;
import com.example.carmaintenancetracker.repository.RefuelRepository;
import com.example.carmaintenancetracker.service.RefuelService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RefuelServiceImpl implements RefuelService {
    private final CarRepository carRepository;
    private final RefuelRepository refuelRepository;

    public RefuelServiceImpl(CarRepository carRepository,
                             RefuelRepository refuelRepository) {
        this.carRepository = carRepository;
        this.refuelRepository = refuelRepository;
    }


    @Override
    public void createRefuel(CreateRefuelDTO createRefuelDTO) {
        RefuelEntity newRefuel = map(createRefuelDTO);

        refuelRepository.save(newRefuel);
    }

    private RefuelEntity map(CreateRefuelDTO createRefuelDTO) {


        int chosenCarId = StringToIdOnly(createRefuelDTO.getCarId());;

        //todo: Add car id

        CarEntity car = carRepository.findById((long) chosenCarId).orElseThrow(() -> new RuntimeException("Invalid car ID"));



        return new RefuelEntity().setCar(car)
                .setTripName(createRefuelDTO.getTripName())
                .setKilometers(createRefuelDTO.getKilometers())
                .setLitres(createRefuelDTO.getLitres())
                .setPrice(createRefuelDTO.getPrice())
                .setFuel(createRefuelDTO.getFuel())
                .setDescription(createRefuelDTO.getDescription());
    }

    static int StringToIdOnly(String carId2) {
        String carChoice = carId2;
        int chosenCarId = 0;

        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(carChoice);
        if (matcher.find()) {
            chosenCarId = Integer.parseInt(matcher.group());
        }else {
            System.out.println("No number for Id found");
        }
        return chosenCarId;
    }
}

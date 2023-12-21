package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.enums.FuelEnum;

import java.time.LocalDate;

public class CreateCarDTO {

    private String model;

    private String brand;

    private LocalDate manufactureYear;

    private LocalDate bought;

    private int mileage;

    private FuelEnum fuelEngineType;

    private int engineDisplacement;

    //todo: finishing CreateCarDTO

}

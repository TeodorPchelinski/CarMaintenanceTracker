package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.entity.VignetteEntity;
import com.example.carmaintenancetracker.model.enums.FuelEnum;
import com.example.carmaintenancetracker.model.enums.FuelTypeEnum;
import com.example.carmaintenancetracker.model.enums.TransmissionEnum;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.List;

public class CreateCarDTO {

    private String model;

    private String brand;

    @PastOrPresent
    private LocalDate manufactureYear;

    @PastOrPresent
    private LocalDate bought;

    private int mileage;

    private FuelEnum fuelEngineType;

    private int engineDisplacement;

    private FuelTypeEnum fuels;

    private TransmissionEnum transmission;

    public String getModel() {
        return model;
    }

    public CreateCarDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CreateCarDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public LocalDate getManufactureYear() {
        return manufactureYear;
    }

    public CreateCarDTO setManufactureYear(LocalDate manufactureYear) {
        this.manufactureYear = manufactureYear;
        return this;
    }

    public LocalDate getBought() {
        return bought;
    }

    public CreateCarDTO setBought(LocalDate bought) {
        this.bought = bought;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public CreateCarDTO setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public FuelEnum getFuelEngineType() {
        return fuelEngineType;
    }

    public CreateCarDTO setFuelEngineType(FuelEnum fuelEngineType) {
        this.fuelEngineType = fuelEngineType;
        return this;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public CreateCarDTO setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
        return this;
    }

    public FuelTypeEnum getFuels() {
        return fuels;
    }

    public CreateCarDTO setFuels(FuelTypeEnum fuels) {
        this.fuels = fuels;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public CreateCarDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }
//todo: finishing CreateCarDTO

}

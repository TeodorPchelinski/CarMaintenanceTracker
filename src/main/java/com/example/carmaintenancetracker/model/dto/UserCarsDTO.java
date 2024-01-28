package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.model.enums.FuelEnum;

import java.time.LocalDate;

public class UserCarsDTO {

    String brand;

    String model;

    int engine;

    FuelEnum fuelType;

    LocalDate year;

    Long ownerId;

    public UserCarsDTO(String brand, String model, int engine, FuelEnum fuelType, LocalDate year, Long ownerId) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.fuelType = fuelType;
        this.year = year;
        this.ownerId = ownerId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public UserCarsDTO setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public UserCarsDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public UserCarsDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public int getEngine() {
        return engine;
    }

    public UserCarsDTO setEngine(int engine) {
        this.engine = engine;
        return this;
    }

    public FuelEnum getFuelType() {
        return fuelType;
    }

    public UserCarsDTO setFuelType(FuelEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public LocalDate getYear() {
        return year;
    }

    public UserCarsDTO setYear(LocalDate year) {
        this.year = year;
        return this;
    }
}

package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.enums.FuelTypeEnum;

import java.math.BigDecimal;

public class CreateRefuelDTO {

    private String tripName;

    private String carId;

    private int kilometers;

    private BigDecimal litres;

    private BigDecimal price;

    private FuelTypeEnum fuel;

    private String description;

    public CreateRefuelDTO(String tripName, String carId, int kilometers, BigDecimal litres, BigDecimal price, FuelTypeEnum fuel, String description) {
        this.tripName = tripName;
        this.carId = carId;
        this.kilometers = kilometers;
        this.litres = litres;
        this.price = price;
        this.fuel = fuel;
        this.description = description;
    }

    public String getCarId() {
        return carId;
    }

    public CreateRefuelDTO setCarId(String carId) {
        this.carId = carId;
        return this;
    }

    public String getTripName() {
        return tripName;
    }

    public CreateRefuelDTO setTripName(String tripName) {
        this.tripName = tripName;
        return this;
    }

    public int getKilometers() {
        return kilometers;
    }

    public CreateRefuelDTO setKilometers(int kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public BigDecimal getLitres() {
        return litres;
    }

    public CreateRefuelDTO setLitres(BigDecimal litres) {
        this.litres = litres;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CreateRefuelDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public FuelTypeEnum getFuel() {
        return fuel;
    }

    public CreateRefuelDTO setFuel(FuelTypeEnum fuel) {
        this.fuel = fuel;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateRefuelDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}

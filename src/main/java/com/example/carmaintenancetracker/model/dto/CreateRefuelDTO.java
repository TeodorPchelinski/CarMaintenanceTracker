package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.enums.FuelTypeEnum;

import java.math.BigDecimal;

public class CreateRefuelDTO {

    private String tripName;

    private int kilometers;

    private double litres;

    private BigDecimal price;

    private FuelTypeEnum fuel;

    private String description;

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

    public double getLitres() {
        return litres;
    }

    public CreateRefuelDTO setLitres(double litres) {
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

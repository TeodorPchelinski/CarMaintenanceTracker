package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.enums.FuelEnum;
import com.example.carmaintenancetracker.model.enums.TransmissionEnum;

import java.time.LocalDate;

public class CarSummaryDTO {

    //todo: add only the fields that will be shown in Car Cards

    String brand;

    String model;

    int engineDisplacement;

    LocalDate year;

    FuelEnum fuelEnum;

    TransmissionEnum transmissionEnum;

    public CarSummaryDTO(String brand, String model, int engineDisplacement, LocalDate manufactureYear, FuelEnum fuelType, TransmissionEnum transmission) {

    }



    public String getBrand() {
        return brand;
    }

    public CarSummaryDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarSummaryDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public CarSummaryDTO setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
        return this;
    }

    public LocalDate getYear() {
        return year;
    }

    public CarSummaryDTO setYear(LocalDate year) {
        this.year = year;
        return this;
    }

    public FuelEnum getFuelEnum() {
        return fuelEnum;
    }

    public CarSummaryDTO setFuelEnum(FuelEnum fuelEnum) {
        this.fuelEnum = fuelEnum;
        return this;
    }

    public TransmissionEnum getTransmissionEnum() {
        return transmissionEnum;
    }

    public CarSummaryDTO setTransmissionEnum(TransmissionEnum transmissionEnum) {
        this.transmissionEnum = transmissionEnum;
        return this;
    }
}

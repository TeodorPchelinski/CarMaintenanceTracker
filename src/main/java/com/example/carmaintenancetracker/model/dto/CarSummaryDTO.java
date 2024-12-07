package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.enums.FuelEnum;
import com.example.carmaintenancetracker.model.enums.TransmissionEnum;

import java.time.LocalDate;

public class CarSummaryDTO {

    //todo: add only the fields that will be shown in Car Cards

    private Long id;

    //todo: Add ImageUrl for cars' images

    private String image;

    private String brand;

    private String model;

    private String engineDisplacement;

    private int year;

    private FuelEnum fuelEnum;

    private TransmissionEnum transmissionEnum;


    public CarSummaryDTO() {

    }

    public Long getId() {
        return id;
    }

    public CarSummaryDTO setId(Long id) {
        this.id = id;
        return this;
    }


    public String getImage() {
        return image;
    }

    public CarSummaryDTO setImage(String image) {
        this.image = image;
        return this;
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

    public String getEngineDisplacement() {
        return engineDisplacement;
    }

    public CarSummaryDTO setEngineDisplacement(String engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
        return this;
    }

    public int getYear() {
        return year;
    }

    public CarSummaryDTO setYear(int year) {
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

    public String summary() {
        return brand + " " + model + " " + engineDisplacement + " " + year + " " + fuelEnum;
    }

    public String brand() {
        return brand;
    }

    @Override
    public String toString() {
        return "CarSummaryDTO{" +
                "id='" + id + '\'' +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineDisplacement=" + engineDisplacement +
                ", year=" + year +
                ", fuelEnum=" + fuelEnum +
                ", transmissionEnum=" + transmissionEnum +
                '}';
    }
}

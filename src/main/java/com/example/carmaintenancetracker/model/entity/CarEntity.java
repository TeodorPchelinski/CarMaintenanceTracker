package com.example.carmaintenancetracker.model.entity;

import com.example.carmaintenancetracker.model.enums.FuelEnum;
import com.example.carmaintenancetracker.model.enums.TransmissionEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cars")
public class CarEntity extends BaseEntity {

    //todo: adding image name as String referring for an image searched by name

    private String model;

    private String brand;

    private LocalDate manufactureYear;

    private LocalDate bought;

    private int mileage;

    @ManyToOne
    private UserEntity owner;

    @Enumerated(EnumType.STRING)
    private FuelEnum fuelType;

    // number -> 800, 1000, 2200, 4500 cubic cm -> Shown as cubic 2200 = 2.2L in liters
    private int engineDisplacement;

    // todo: Maybe Adding fuel economy

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;

    // Vignette Entity ->  start date, expire date, period( week, month, year), [can be added 2 country vignette active at the same time]
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<VignetteEntity> vignette;

    // todo: Tires Entity -> image
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<TireEntity> tire;

    // todo: Annual technical inspection Entity -> start date, expire date
    @OneToOne
    private InspectionEntity technicalInspection;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<RefuelEntity> charges;



    public String getModel() {
        return model;
    }

    public CarEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public LocalDate getManufactureYear() {
        return manufactureYear;
    }

    public CarEntity setManufactureYear(LocalDate manufactureYear) {
        this.manufactureYear = manufactureYear;
        return this;
    }

    public LocalDate getBought() {
        return bought;
    }

    public CarEntity setBought(LocalDate bought) {
        this.bought = bought;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public CarEntity setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public CarEntity setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public FuelEnum getFuelType() {
        return fuelType;
    }

    public CarEntity setFuelType(FuelEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public CarEntity setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public CarEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public List<VignetteEntity> getVignette() {
        return vignette;
    }

    public CarEntity setVignette(List<VignetteEntity> vignette) {
        this.vignette = vignette;
        return this;
    }

    public List<TireEntity> getTire() {
        return tire;
    }

    public CarEntity setTire(List<TireEntity> tire) {
        this.tire = tire;
        return this;
    }

    public InspectionEntity getTechnicalInspection() {
        return technicalInspection;
    }

    public CarEntity setTechnicalInspection(InspectionEntity technicalInspection) {
        this.technicalInspection = technicalInspection;
        return this;
    }

    public List<RefuelEntity> getCharges() {
        return charges;
    }

    public CarEntity setCharges(List<RefuelEntity> charges) {
        this.charges = charges;
        return this;
    }
}

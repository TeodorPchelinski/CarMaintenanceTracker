package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "inspections")
public class InspectionEntity extends BaseEntity {

    private LocalDate startDate;

    private LocalDate expireDate;

    private String location;

    @OneToOne
    private CarEntity car;


    public LocalDate getStartDate() {
        return startDate;
    }

    public InspectionEntity setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public InspectionEntity setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public InspectionEntity setLocation(String location) {
        this.location = location;
        return this;
    }

    public CarEntity getCar() {
        return car;
    }

    public InspectionEntity setCar(CarEntity car) {
        this.car = car;
        return this;
    }
}

package com.example.carmaintenancetracker.model.entity;

import com.example.carmaintenancetracker.model.enums.VignettePeriodEnum;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "vignettes")
public class VignetteEntity extends BaseEntity{

    // Vignette Entity ->  start date, expire date, [can be added 2 country vignette active at the same time]

    private LocalDate startDate;

    private LocalDate expireDate;

    //Track pass, Weekend, Week, Month, 3Months, Year
    @Enumerated(EnumType.STRING)
    private VignettePeriodEnum period;

    @ManyToOne
    private CarEntity car;

    public LocalDate getStartDate() {
        return startDate;
    }

    public VignetteEntity setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public VignetteEntity setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public VignettePeriodEnum getPeriod() {
        return period;
    }

    public VignetteEntity setPeriod(VignettePeriodEnum period) {
        this.period = period;
        return this;
    }

    public CarEntity getCar() {
        return car;
    }

    public VignetteEntity setCar(CarEntity car) {
        this.car = car;
        return this;
    }
}

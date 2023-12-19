package com.example.carmaintenancetracker.model.entity;

import com.example.carmaintenancetracker.model.enums.FuelTypeEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "refuelings")
public class RefuelEntity extends BaseEntity{

    private String tripName;

    private int kilometers;

    private int litres;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private FuelTypeEnum fuel;

    private String description;

    @ManyToOne
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public String getTripName() {
        return tripName;
    }

    public RefuelEntity setTripName(String tripName) {
        this.tripName = tripName;
        return this;
    }

    public int getKilometers() {
        return kilometers;
    }

    public RefuelEntity setKilometers(int kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public int getLitres() {
        return litres;
    }

    public RefuelEntity setLitres(int litres) {
        this.litres = litres;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public RefuelEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public FuelTypeEnum getFuel() {
        return fuel;
    }

    public RefuelEntity setFuel(FuelTypeEnum fuel) {
        this.fuel = fuel;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RefuelEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public CarEntity getCar() {
        return car;
    }

    public RefuelEntity setCar(CarEntity car) {
        this.car = car;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public RefuelEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}

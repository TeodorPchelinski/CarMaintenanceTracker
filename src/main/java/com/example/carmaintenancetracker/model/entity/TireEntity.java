package com.example.carmaintenancetracker.model.entity;


import com.example.carmaintenancetracker.model.enums.TireBrandEnum;
import com.example.carmaintenancetracker.model.enums.TirePositionEnum;
import com.example.carmaintenancetracker.model.enums.TireTypeEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tires")
public class TireEntity extends BaseEntity{
    // todo: Tires Entity -> DOT, dimensions, winter, summer and all seasons, brand, name(model), image, winter and summer change dates,

    //todo:  0619 or 2019 or both -> convert week + year to date
    private LocalDate DOT;

    //todo: green, yellow, orange and red  -> for 0-3 years, 4-5 years, 6-7 years, 8-10 years
    private LocalDate expireYear;

    // 215
    private int width;

    //35
    private int height;

    //R 15
    private int size;

    //DEBICA, PIRELLI, GOODYEAR, MICHELIN
    private TireBrandEnum brand;

    //todo: PASSIO2, FRIGO
    private String model;

    //Winter, Summer, AllSeason, Mud, Off-road
    @Enumerated(EnumType.STRING)
    private TireTypeEnum season;

    // 1 Front-Left, 2 Front-Right, 3 Back-Left, 4 Back-Right, 5 Spare, 6 Storage
    @Enumerated(EnumType.STRING)
    private TirePositionEnum position;

    @ManyToOne
    private CarEntity car;

    public LocalDate getDOT() {
        return DOT;
    }

    public TireEntity setDOT(LocalDate DOT) {
        this.DOT = DOT;
        return this;
    }

    public LocalDate getExpireYear() {
        return expireYear;
    }

    public TireEntity setExpireYear(LocalDate expireYear) {
        this.expireYear = expireYear;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public TireEntity setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public TireEntity setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getSize() {
        return size;
    }

    public TireEntity setSize(int size) {
        this.size = size;
        return this;
    }

    public TireBrandEnum getBrand() {
        return brand;
    }

    public TireEntity setBrand(TireBrandEnum brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public TireEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public TireTypeEnum getSeason() {
        return season;
    }

    public TireEntity setSeason(TireTypeEnum season) {
        this.season = season;
        return this;
    }

    public TirePositionEnum getPosition() {
        return position;
    }

    public TireEntity setPosition(TirePositionEnum position) {
        this.position = position;
        return this;
    }

    public CarEntity getCar() {
        return car;
    }

    public TireEntity setCar(CarEntity car) {
        this.car = car;
        return this;
    }
}

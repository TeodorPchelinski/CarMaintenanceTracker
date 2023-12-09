package com.example.carmaintenancetracker.model.entity;

import com.example.carmaintenancetracker.model.enums.FuelEnum;
import com.example.carmaintenancetracker.model.enums.TransmissionEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "car")
public class CarEntity extends BaseEntity {


    private String model;

    private String brand;

    private int manufactureYear;

    private int boughtYear;

    @ManyToOne
    private UserEntity owner;

    @Enumerated(EnumType.STRING)
    private FuelEnum fuelType;

    // todo: number -> 800, 1000, 2200, 4500 cubic cm -> Shown as cubic / 1000 = 2.2L in liters
    private int engineDisplacement;

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;

    // todo: Vignette Entity ->  start date, expire date, period( week, month, year), [can be added 2 country vignette active at the same time]
    private String vignette;

    // todo: Tires Entity -> image, @ManyToOne or @OneToMany FIX

    @ManyToOne
    @JoinColumn(name = "tires_id")
    private TireEntity tires;

    // todo: Annual technical inspection Entity -> expire date
    private String ГТП;

}

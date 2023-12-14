package com.example.carmaintenancetracker.model.entity;

import com.example.carmaintenancetracker.model.enums.FuelEnum;
import com.example.carmaintenancetracker.model.enums.TransmissionEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cars")
public class CarEntity extends BaseEntity {


    private String model;

    private String brand;

    private LocalDate manufactureYear;

    private LocalDate bought;

    @ManyToOne
    private UserEntity owner;

    @Enumerated(EnumType.STRING)
    private FuelEnum fuelType;

    // number -> 800, 1000, 2200, 4500 cubic cm -> Shown as cubic / 1000 = 2.2L in liters
    private int engineDisplacement;

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;

    // Vignette Entity ->  start date, expire date, period( week, month, year), [can be added 2 country vignette active at the same time]
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carOn")
    private List<VignetteEntity> vignette;

    // todo: Tires Entity -> image
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carOn")
    private List<TireEntity> tire;

    // todo: Annual technical inspection Entity -> start date, expire date
    @OneToOne
    private InspectionEntity technicalInspection;

}

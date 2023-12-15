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

    //todo: 23RXZ or 2019 or both
    private LocalDate DOT;

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


}

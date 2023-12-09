package com.example.carmaintenancetracker.model.entity;


import com.example.carmaintenancetracker.model.enums.TirePositionEnum;
import com.example.carmaintenancetracker.model.enums.TireTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tires")
public class TireEntity extends BaseEntity{
    // todo: Tires Entity -> DOT, dimensions, winter, summer and all seasons, brand, name(model), image, winter and summer change dates,

    //todo: 23RXZ or 2019 or both
    private String DOT;

    private LocalDate expireYear;

    // 215
    private int width;

    //35
    private int height;

    //R 15
    private int size;

    //todo: DEBICA, PIRELLI, GOODYEAR, MICHELIN
    private String brand;

    //todo: PASSIO2, FRIGO
    private String model;

    //todo: Winter, Summer, AllSeason, Mud, Off-road
    @Enumerated(EnumType.STRING)
    private TireTypeEnum season;

    //todo: 1 Front-Left, 2 Front-Right, 3 Back-Left, 4 Back-Right, 5 Spare, 6 Storage
    @Enumerated(EnumType.STRING)
    private TirePositionEnum position;


}

package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RepairEntity extends BaseEntity {

    private String name;

    @OneToMany()
    private List<PartEntity> parts;

    private CarServiceEntity service;

    private GpsCoordinatesEntity serviceLocation;

    private ShopEntity shop;

    private ShopEntity shopLocation;

    private BigDecimal totalCost;


    private LocalDate dateCreated;

    private LocalDate dateRepairDone;



}

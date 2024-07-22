package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "repairs")
public class RepairEntity extends BaseEntity {

    private String name;

    @OneToMany()
    private List<PartEntity> parts;

    @ManyToOne
    private ServiceEntity service;

    @OneToOne
    private GpsCoordinatesEntity serviceLocation;

    @ManyToMany
    private List<ShopEntity> shop;

    private BigDecimal totalCost;


    private LocalDate dateCreated;

    private LocalDate dateRepairDone;



}

package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Entity
//@Table(name = "parts")
public class PartEntity extends BaseEntity {

    private String name;

    private String description;

    @ManyToOne
    private RepairEntity repair;

    @ManyToOne
    private CarEntity car;

    private LocalDate dateCreated;

    private List<LocalDate> latestChanges;

    //todo: part cost and all cost in Repairs + cost of work
    private BigDecimal partCost;
}

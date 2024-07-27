package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "parts")
public class PartEntity extends BaseEntity {

    //Name of the part
    private String name;

    private String description;

    @ManyToOne
    private RepairEntity repair;

    @ManyToOne
    private CarEntity car;

    private LocalDate dateCreated;

    //todo: part cost and all cost in Repairs + cost of work
    private BigDecimal partCost;

    private int quantity;

    public String getName() {
        return name;
    }

    public PartEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PartEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public RepairEntity getRepair() {
        return repair;
    }

    public PartEntity setRepair(RepairEntity repair) {
        this.repair = repair;
        return this;
    }

    public CarEntity getCar() {
        return car;
    }

    public PartEntity setCar(CarEntity car) {
        this.car = car;
        return this;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public PartEntity setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public BigDecimal getPartCost() {
        return partCost;
    }

    public PartEntity setPartCost(BigDecimal partCost) {
        this.partCost = partCost;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public PartEntity setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}

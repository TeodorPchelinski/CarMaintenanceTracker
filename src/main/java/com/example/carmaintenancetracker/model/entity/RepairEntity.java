package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "repairs")
public class RepairEntity extends BaseEntity {

    private String name;

    @OneToMany
    private List<PartEntity> parts;

    @ManyToOne
    private ServiceEntity service;

    @ManyToMany
    private List<ShopEntity> shop;

    private BigDecimal totalCost;

    @ManyToOne
    private CarEntity car;

    private LocalDate dateCreated;

    private LocalDate dateRepairDone;

    public String getName() {
        return name;
    }

    public RepairEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<PartEntity> getParts() {
        return parts;
    }

    public RepairEntity setParts(List<PartEntity> parts) {
        this.parts = parts;
        return this;
    }

    public ServiceEntity getService() {
        return service;
    }

    public RepairEntity setService(ServiceEntity service) {
        this.service = service;
        return this;
    }

    public List<ShopEntity> getShop() {
        return shop;
    }

    public RepairEntity setShop(List<ShopEntity> shop) {
        this.shop = shop;
        return this;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public RepairEntity setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public CarEntity getCar(Long carId) {
        return car;
    }

    public RepairEntity setCar(CarEntity car) {
        this.car = car;
        return this;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public RepairEntity setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public LocalDate getDateRepairDone() {
        return dateRepairDone;
    }

    public RepairEntity setDateRepairDone(LocalDate dateRepairDone) {
        this.dateRepairDone = dateRepairDone;
        return this;
    }
}

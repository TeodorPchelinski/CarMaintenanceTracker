package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "repairs")
public class RepairEntity extends BaseEntity {

    private String name;

    private String image;

    @OneToMany
    private List<PartEntity> parts;

    @ManyToOne
    private ServiceEntity service;

    @ManyToMany
    private List<ShopEntity> shop;

    private BigDecimal totalCost;

    @ManyToOne
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private UserEntity creator;

    private LocalDate dateCreated;

    private LocalDate dateRepairDone;

    public UserEntity getCreator() {
        return creator;
    }

    public RepairEntity setCreator(UserEntity creator) {
        this.creator = creator;
        return this;
    }

    public RepairEntity() {
    }

    public String getName() {
        return name;
    }

    public RepairEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getImage() {
        return image;
    }

    public RepairEntity setImage(String image) {
        this.image = image;
        return this;
    }

    public CarEntity getCar() {
        return car;
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

    public RepairEntity setCreator(Optional<UserEntity> id) {
        return this;
    }
}

package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "inspections")
public class InspectionEntity extends BaseEntity {

    private LocalDate startDate;

    private LocalDate expireDate;

    private String location;

    @OneToOne
    private CarEntity carOn;
}

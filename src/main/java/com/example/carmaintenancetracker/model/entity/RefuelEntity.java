package com.example.carmaintenancetracker.model.entity;

import com.example.carmaintenancetracker.model.enums.FuelTypeEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "refuelings")
public class RefuelEntity extends BaseEntity{

    private String tripName;

    private int kilometers;

    private int litres;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private FuelTypeEnum fuel;

    private String description;

    @ManyToOne
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


}

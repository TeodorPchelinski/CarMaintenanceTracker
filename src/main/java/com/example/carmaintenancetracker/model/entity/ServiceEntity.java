package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "services")
public class ServiceEntity extends BaseEntity {

    private String name;

    private String imageUrl;

    private int userRating;

    private String description;

    @OneToMany
    private List<RepairEntity> repair;

    @OneToOne
    private GpsCoordinatesEntity location;


}

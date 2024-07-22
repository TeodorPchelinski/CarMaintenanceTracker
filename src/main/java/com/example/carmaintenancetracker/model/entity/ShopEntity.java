package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shops")
public class ShopEntity extends BaseEntity {

    private String name;

    private String imageUrl;

    private int userRating;

    private String description;

    @OneToOne
    private GpsCoordinatesEntity location;
}

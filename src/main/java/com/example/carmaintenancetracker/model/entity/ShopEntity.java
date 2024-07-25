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

    public String getName() {
        return name;
    }

    public ShopEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ShopEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getUserRating() {
        return userRating;
    }

    public ShopEntity setUserRating(int userRating) {
        this.userRating = userRating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ShopEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public GpsCoordinatesEntity getLocation() {
        return location;
    }

    public ShopEntity setLocation(GpsCoordinatesEntity location) {
        this.location = location;
        return this;
    }
}

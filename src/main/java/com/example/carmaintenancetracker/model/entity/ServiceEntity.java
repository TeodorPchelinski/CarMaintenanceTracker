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


    public String getName() {
        return name;
    }

    public ServiceEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ServiceEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getUserRating() {
        return userRating;
    }

    public ServiceEntity setUserRating(int userRating) {
        this.userRating = userRating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ServiceEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<RepairEntity> getRepair() {
        return repair;
    }

    public ServiceEntity setRepair(List<RepairEntity> repair) {
        this.repair = repair;
        return this;
    }

    public GpsCoordinatesEntity getLocation() {
        return location;
    }

    public ServiceEntity setLocation(GpsCoordinatesEntity location) {
        this.location = location;
        return this;
    }
}

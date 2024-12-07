package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;


@Entity
@Table(name = "gps_coordinates")
public class GpsCoordinatesEntity extends BaseEntity {

    private double latitude;

    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public GpsCoordinatesEntity setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public GpsCoordinatesEntity setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }
}

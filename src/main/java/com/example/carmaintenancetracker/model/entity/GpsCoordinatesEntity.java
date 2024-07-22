package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;


@Entity
@Table(name = "gps_coordinates")
public class GpsCoordinatesEntity extends BaseEntity {

    private double latitude;

    private double longitude;


}

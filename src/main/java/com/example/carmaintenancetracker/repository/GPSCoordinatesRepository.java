package com.example.carmaintenancetracker.repository;

import com.example.carmaintenancetracker.model.entity.GpsCoordinatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPSCoordinatesRepository extends JpaRepository<GpsCoordinatesEntity, Long> {
}

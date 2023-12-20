package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarService extends JpaRepository<CarEntity, Long> {

    void createCar();

}

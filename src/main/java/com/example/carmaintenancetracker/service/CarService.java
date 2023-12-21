package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarService extends JpaRepository<CarEntity, Long> {

//    void createCar();

}

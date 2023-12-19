package com.example.carmaintenancetracker.repositories;

import com.example.carmaintenancetracker.model.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

}

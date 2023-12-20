package com.example.carmaintenancetracker.repository;

import com.example.carmaintenancetracker.model.entity.TireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TireRepository extends JpaRepository<TireEntity, Long> {
}

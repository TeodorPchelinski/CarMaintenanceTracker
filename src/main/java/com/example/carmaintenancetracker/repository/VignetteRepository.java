package com.example.carmaintenancetracker.repository;

import com.example.carmaintenancetracker.model.entity.VignetteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VignetteRepository extends JpaRepository<VignetteEntity, Long> {
}

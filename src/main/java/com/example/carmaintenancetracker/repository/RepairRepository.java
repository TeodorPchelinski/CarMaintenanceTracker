package com.example.carmaintenancetracker.repository;

import com.example.carmaintenancetracker.model.entity.RepairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<RepairEntity, Long> {

}

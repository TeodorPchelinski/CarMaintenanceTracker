package com.example.carmaintenancetracker.repository;

import com.example.carmaintenancetracker.model.entity.PartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<PartEntity, Long> {

}

package com.example.carmaintenancetracker.repositories;

import com.example.carmaintenancetracker.model.entity.InspectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionRepository extends JpaRepository<InspectionEntity, Long> {


}

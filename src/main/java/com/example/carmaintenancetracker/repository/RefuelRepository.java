package com.example.carmaintenancetracker.repository;

import com.example.carmaintenancetracker.model.entity.RefuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefuelRepository extends JpaRepository<RefuelEntity, Long> {


}

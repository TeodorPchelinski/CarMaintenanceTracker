package com.example.carmaintenancetracker.repository;

import com.example.carmaintenancetracker.model.dto.CarSummaryDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    List<CarEntity> findAllByOwner(UserEntity owner);


    Page<CarEntity> findAllByOwnerId(Long valueOf, Pageable pageable);
    // No need of Page here -> I have a list already

}

package com.example.carmaintenancetracker.repository;

import com.example.carmaintenancetracker.model.dto.RecentRepairsDTO;
import com.example.carmaintenancetracker.model.entity.RepairEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<RepairEntity, Long> {


    Page<RecentRepairsDTO> findAllRepairsByCreatorOrderByCreatorDesc (Long number, Pageable pageable);
}

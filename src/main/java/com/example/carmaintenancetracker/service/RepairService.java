package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.dto.CreateRepairDTO;
import com.example.carmaintenancetracker.model.dto.RecentRepairsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepairService {



    Long createRepair(CreateRepairDTO createRepairDTO, UserDetails creator);

    Page<RecentRepairsDTO> getAllRepairsByCreatorId(Pageable pageable, UserDetails creator);
}

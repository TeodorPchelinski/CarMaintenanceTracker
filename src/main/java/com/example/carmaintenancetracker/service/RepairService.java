package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.dto.CreateRepairDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepairService {

    Long createRepair(CreateRepairDTO createRepairDTO);
}

package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CreateRefuelDTO;
import com.example.carmaintenancetracker.model.entity.RefuelEntity;
import com.example.carmaintenancetracker.service.RefuelService;
import org.springframework.stereotype.Service;

@Service
public class RefuelServiceImpl implements RefuelService {


    @Override
    public Long createRefuel(CreateRefuelDTO createRefuelDTO) {

        RefuelEntity newRefuel = map(createRefuelDTO);


        return null;
    }

    private RefuelEntity map(CreateRefuelDTO createRefuelDTO) {
        return null;
    }
}

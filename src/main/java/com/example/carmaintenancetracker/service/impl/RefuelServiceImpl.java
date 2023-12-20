package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CreateRefuelDTO;
import com.example.carmaintenancetracker.model.entity.RefuelEntity;
import com.example.carmaintenancetracker.service.RefuelService;
import org.springframework.stereotype.Service;

@Service
public class RefuelServiceImpl implements RefuelService {


    @Override
    public void createRefuel(CreateRefuelDTO createRefuelDTO) {
        RefuelEntity newRefuel = map(createRefuelDTO);
    }

    private RefuelEntity map(CreateRefuelDTO createRefuelDTO) {

        //todo: Add car id

        return new RefuelEntity().setTripName(createRefuelDTO.getTripName())
                .setKilometers(createRefuelDTO.getKilometers())
                .setLitres(createRefuelDTO.getLitres())
                .setPrice(createRefuelDTO.getPrice())
                .setFuel(createRefuelDTO.getFuel())
                .setDescription(createRefuelDTO.getDescription());
    }
}

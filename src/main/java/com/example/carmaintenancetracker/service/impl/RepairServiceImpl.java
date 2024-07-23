package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.dto.CreateRepairDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.entity.PartEntity;
import com.example.carmaintenancetracker.model.entity.RepairEntity;
import com.example.carmaintenancetracker.repository.CarRepository;
import com.example.carmaintenancetracker.service.RepairService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
public class RepairServiceImpl implements RepairService {
    private final CarRepository carRepository;

    public RepairServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Long createRepair(CreateRepairDTO createRepairDTO, UserDetails userDetails){
        CarEntity carEntity = carRepository.findById(createRepairDTO.getCarId()).orElseThrow(() -> new RuntimeException("Invalid car ID"));


        //todo: finish and save all Entities (Repair, Part, Service, Shop)

        RepairEntity newRepair = new RepairEntity()
                .setCar(carEntity)
                .setName(createRepairDTO.getRepairTitle())
                .setDateRepairDone(createRepairDTO.getDateSelected())
                .setTotalCost(createRepairDTO.getTotalCost())
                .setDateCreated(LocalDate.now());

        PartEntity newPart = new PartEntity()
                .setName(createRepairDTO.getPartName())
                .setPartCost(createRepairDTO.getPartPrice())
                .setRepair(newRepair);




        return null;
    }


}

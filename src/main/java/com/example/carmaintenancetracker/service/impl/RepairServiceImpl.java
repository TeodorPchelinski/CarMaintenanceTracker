package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.dto.CreateRepairDTO;
import com.example.carmaintenancetracker.model.entity.*;
import com.example.carmaintenancetracker.repository.CarRepository;
import com.example.carmaintenancetracker.service.RepairService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    private final CarRepository carRepository;

    public RepairServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Long createRepair(CreateRepairDTO createRepairDTO, UserDetails userDetails){
        CarEntity carEntity = carRepository.findById(createRepairDTO.getCarId()).orElseThrow(() -> new RuntimeException("Invalid car ID"));


        //todo: finish and save all Entities (Repair, Part, Service, Shop)

        //REPAIR
        RepairEntity newRepair = new RepairEntity()
                .setCar(carEntity)
                .setName(createRepairDTO.getRepairTitle())
                .setDateRepairDone(createRepairDTO.getDateSelected())
                .setTotalCost(createRepairDTO.getTotalCost())
                .setDateCreated(LocalDate.now());

        //SERVICE
        ServiceEntity newService = new ServiceEntity()
                .setName(createRepairDTO.getServiceName())
                .setDescription(createRepairDTO.getDescription())
                .setLocation(createRepairDTO.getServiceLocation());

        newRepair.setService(newService);

        //SHOP
        //List of Shops
        List<ShopEntity> shops = new ArrayList<>();

        ShopEntity newShop = new ShopEntity()
                .setName(createRepairDTO.getShopName())
                .setLocation(createRepairDTO.getShopLocation());

        //All shops here -> if it has multiple shops
        newRepair.setShop(shops);

        //if Shop is only one
        newRepair.setShop(Collections.singletonList(newShop));


        PartEntity newPart = new PartEntity()
                .setName(createRepairDTO.getPartName())
                .setPartCost(createRepairDTO.getPartPrice())
                .setRepair(newRepair);




        return null;
    }


}

package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CreateRepairDTO;
import com.example.carmaintenancetracker.model.entity.*;
import com.example.carmaintenancetracker.repository.CarRepository;
import com.example.carmaintenancetracker.repository.PartRepository;
import com.example.carmaintenancetracker.repository.RepairRepository;
import com.example.carmaintenancetracker.repository.ServiceRepository;
import com.example.carmaintenancetracker.service.RepairService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    private final CarRepository carRepository;

    private final RepairRepository repairRepository;

    private final ServiceRepository serviceRepository;

    private final PartRepository partRepository;

    public RepairServiceImpl(CarRepository carRepository, RepairRepository repairRepository, ServiceRepository serviceRepository, PartRepository partRepository) {
        this.carRepository = carRepository;
        this.repairRepository = repairRepository;
        this.serviceRepository = serviceRepository;
        this.partRepository = partRepository;
    }

    @Override
    public Long createRepair(CreateRepairDTO createRepairDTO) {
        CarEntity carEntity = carRepository.findById(createRepairDTO.getCarId()).orElseThrow(() -> new RuntimeException("Invalid car ID"));


        //todo: finish and save all Entities (Repair, Part, Service, Shop)

        //REPAIR
        RepairEntity newRepair = new RepairEntity()
                .setCar(carEntity)
                .setName(createRepairDTO.getRepairTitle())
                .setDateRepairDone(createRepairDTO.getDateSelected())
                .setTotalCost(createRepairDTO.getTotalCost())
                .setDateCreated(LocalDate.now());

        System.out.println(newRepair);

        //SERVICE
        ServiceEntity newService = new ServiceEntity()
                .setName(createRepairDTO.getServiceName())
                .setDescription(createRepairDTO.getDescription())
                .setLocation(null);// needs Map

        newRepair.setService(newService);

        newRepair = repairRepository.save(newRepair);

        newService.setRepair(newRepair.getService().getRepair());

        serviceRepository.save(newService);

        //SHOP
        ShopEntity newShop = new ShopEntity()
                .setName(createRepairDTO.getShopName())
                .setLocation(null); //needs Map


        newRepair.setShop(Collections.singletonList(newShop));

        List<PartEntity> newParts = new ArrayList<>();
        addPartIfPresent(newParts, createRepairDTO.getPartName1(), createRepairDTO.getPartPrice1(), createRepairDTO.getPartQuantity1(), carEntity, newRepair);
        addPartIfPresent(newParts, createRepairDTO.getPartName2(), createRepairDTO.getPartPrice2(), createRepairDTO.getPartQuantity2(), carEntity, newRepair);
        addPartIfPresent(newParts, createRepairDTO.getPartName3(), createRepairDTO.getPartPrice3(), createRepairDTO.getPartQuantity3(), carEntity, newRepair);
        addPartIfPresent(newParts, createRepairDTO.getPartName4(), createRepairDTO.getPartPrice4(), createRepairDTO.getPartQuantity4(), carEntity, newRepair);

        newRepair.setParts(newParts);


        repairRepository.save(newRepair);


        return newRepair.getId();
    }

    private void addPartIfPresent(List<PartEntity> newParts, String partName, BigDecimal partPrice, int partQuantity, CarEntity carEntity, RepairEntity newRepair) {
        if (partName != null && !partName.isEmpty()) {
            PartEntity part = new PartEntity()
                    .setName(partName)
                    .setPartCost(partPrice)
                    .setQuantity(partQuantity)
                    .setCar(carEntity)
                    .setRepair(newRepair)
                    .setDateCreated(LocalDate.now());

            partRepository.save(part);

            newParts.add(part);
        }


    }
}

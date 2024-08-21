package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CreateRepairDTO;
import com.example.carmaintenancetracker.model.entity.*;
import com.example.carmaintenancetracker.repository.*;
import com.example.carmaintenancetracker.service.RepairService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RepairServiceImpl implements RepairService {
    private final CarRepository carRepository;

    private final RepairRepository repairRepository;

    private final ServiceRepository serviceRepository;

    private final PartRepository partRepository;
    private final ShopRepository shopRepository;

    public RepairServiceImpl(CarRepository carRepository, RepairRepository repairRepository, ServiceRepository serviceRepository, PartRepository partRepository,
                             ShopRepository shopRepository) {
        this.carRepository = carRepository;
        this.repairRepository = repairRepository;
        this.serviceRepository = serviceRepository;
        this.partRepository = partRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    public Long createRepair(CreateRepairDTO createRepairDTO) {

        int chosenCarId = RefuelServiceImpl.StringToIdOnly(createRepairDTO.getCarId());

        CarEntity carEntity = carRepository.findById((long) chosenCarId).orElseThrow(() -> new RuntimeException("Invalid car ID"));

            //TODO: SAVE One Entity to can save another to it
            // 1 Persist Service
            // 2 Save Service
            // 3 Persist Repair
            // 4 Set Service
            // 5 Save Repair
            // 6 Set Repair to Service
            // 7 Update Service (save)
            // 8 Persist Shop
            // 9 Save Shop
            // 10 Set Shop to Repair
            // 11 Fill List of Parts
            // 12 Set Part List to Repair
            // 13 Save Repair (Update)


        //TODO: Maybe String of CarId is null or something else

        // 1 SERVICE
        ServiceEntity newService = new ServiceEntity()
                .setName(createRepairDTO.getServiceName())
                .setDescription(createRepairDTO.getDescription())
                .setLocation(null);// needs Map
        // 2
        serviceRepository.save(newService);

        // 3 REPAIR
        RepairEntity newRepair = new RepairEntity()
                .setCar(carEntity)
                .setName(createRepairDTO.getRepairTitle())
                .setDateRepairDone(createRepairDTO.getDateSelected())
                .setTotalCost(createRepairDTO.getTotalCost())
                .setDateCreated(LocalDate.now());


        // 4
        newRepair.setService(newService);

        // 5
        newRepair = repairRepository.save(newRepair);


        // 6
        newService.setRepair(newRepair.getService().getRepair());

        // 7
        serviceRepository.save(newService);


        // 8 SHOP
        ShopEntity newShop = new ShopEntity()
                .setName(createRepairDTO.getShopName())
                .setLocation(null); //needs Map

        // 9
        shopRepository.save(newShop);

        // 10
        newRepair.setShop(new ArrayList<>(Collections.singletonList(newShop)));

        // 11
        List<PartEntity> newParts = new ArrayList<>();
        addPartIfPresent(newParts, createRepairDTO.getPartName1(), createRepairDTO.getPartPrice1(), createRepairDTO.getPartQuantity1(), carEntity, newRepair);
        addPartIfPresent(newParts, createRepairDTO.getPartName2(), createRepairDTO.getPartPrice2(), createRepairDTO.getPartQuantity2(), carEntity, newRepair);
        addPartIfPresent(newParts, createRepairDTO.getPartName3(), createRepairDTO.getPartPrice3(), createRepairDTO.getPartQuantity3(), carEntity, newRepair);
        addPartIfPresent(newParts, createRepairDTO.getPartName4(), createRepairDTO.getPartPrice4(), createRepairDTO.getPartQuantity4(), carEntity, newRepair);

        // 12
        newRepair.setParts(new ArrayList<>(newParts));

        //todo: Some problem here with the Array
//        newRepair.getParts().clear();
//        newRepair.getParts().addAll(newParts);


        // 13
        repairRepository.save(newRepair);
        System.out.println(newRepair);

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

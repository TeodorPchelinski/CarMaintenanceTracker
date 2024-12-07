package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CreateRepairDTO;
import com.example.carmaintenancetracker.model.dto.RecentRepairsDTO;
import com.example.carmaintenancetracker.model.entity.*;
import com.example.carmaintenancetracker.repository.*;
import com.example.carmaintenancetracker.service.RepairService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RepairServiceImpl implements RepairService {
    private final CarRepository carRepository;

    private final RepairRepository repairRepository;

    private final ServiceRepository serviceRepository;

    private final GPSCoordinatesRepository gpsCoordinatesRepository;
    private final PartRepository partRepository;
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;

    public RepairServiceImpl(CarRepository carRepository, RepairRepository repairRepository, ServiceRepository serviceRepository, GPSCoordinatesRepository gpsCoordinatesRepository, PartRepository partRepository,
                             ShopRepository shopRepository,
                             UserRepository userRepository) {
        this.carRepository = carRepository;
        this.repairRepository = repairRepository;
        this.serviceRepository = serviceRepository;
        this.gpsCoordinatesRepository = gpsCoordinatesRepository;
        this.partRepository = partRepository;
        this.shopRepository = shopRepository;
        this.userRepository = userRepository;
    }



    @Override
    public Long createRepair(CreateRepairDTO createRepairDTO, UserDetails creator) {

        int chosenCarId = RefuelServiceImpl.StringToIdOnly(createRepairDTO.getCarId());

        CarEntity carEntity = carRepository.findById((long) chosenCarId).orElseThrow(() -> new RuntimeException("Invalid car ID"));
        UserEntity user = userRepository.findByEmail(creator.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User with email " + creator.getUsername() + "not found!"));


        GpsCoordinatesEntity newGPSCoordinates = new GpsCoordinatesEntity()
                .setLatitude(Double.parseDouble(createRepairDTO.getLatitude()))
                .setLongitude(Double.parseDouble(createRepairDTO.getLongitude()));

        gpsCoordinatesRepository.save(newGPSCoordinates);

        System.out.println(createRepairDTO);
        // 1 SERVICE
        ServiceEntity newService = new ServiceEntity()
                .setName(createRepairDTO.getServiceName())
                .setDescription(createRepairDTO.getDescription())
                .setLocation(newGPSCoordinates);// needs Map
//                .setLocation(null);// needs Map
        // 2
        serviceRepository.save(newService);



        // 3 REPAIR
        RepairEntity newRepair = new RepairEntity()
                //todo: user is null -> not saved any time
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
        addPartIfPresent(newParts, createRepairDTO.getPartName1(), createRepairDTO.getPartDescription1(), createRepairDTO.getPartPrice1(), createRepairDTO.getPartQuantity1(), carEntity, newRepair);
        addPartIfPresent(newParts, createRepairDTO.getPartName2(), createRepairDTO.getPartDescription2(), createRepairDTO.getPartPrice2(), createRepairDTO.getPartQuantity2(), carEntity, newRepair);
        addPartIfPresent(newParts, createRepairDTO.getPartName3(), createRepairDTO.getPartDescription3(), createRepairDTO.getPartPrice3(), createRepairDTO.getPartQuantity3(), carEntity, newRepair);
        addPartIfPresent(newParts, createRepairDTO.getPartName4(), createRepairDTO.getPartDescription4(), createRepairDTO.getPartPrice4(), createRepairDTO.getPartQuantity4(), carEntity, newRepair);

        // 12
        newRepair.setParts(new ArrayList<>(newParts));

        newRepair.setCreator(user);

        // 13
        repairRepository.save(newRepair);
        System.out.println(newRepair);


        if (createRepairDTO.getImage() != null && !createRepairDTO.getImage().isEmpty()) {
            MultipartFile imageName = createRepairDTO.getImage();

            try {
                String filePath = ".\\src\\main\\resources\\static\\images\\repairs\\" + newRepair.getId() + ".jpg";
                File file = new File(filePath);

                file.getParentFile().mkdirs();
                file.createNewFile();

                OutputStream outputStream = new FileOutputStream(file);
                outputStream.write(imageName.getBytes());

                newRepair.setImage("\\images\\repairs\\" + newRepair.getId() + ".jpg");

                repairRepository.save(newRepair);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return newRepair.getId();
    }

    @Override
    public Page<RecentRepairsDTO> getAllRepairsByCreatorId(Pageable pageable, UserDetails creator){
        Optional<UserEntity> owner = userRepository.findByEmail(creator.getUsername());
        if (!owner.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }

        Long number = owner.get().getId();

        //todo: Finish All Repairs

        // Can I get ByCreatorIdDesc -> Yes

//        return repairRepository.findAllRepairsByCreatorIdOrderByCreatorDesc(number, pageable).map(RepairServiceImpl::mapRepairsAsSummary);


        return null;
    }


    private static RecentRepairsDTO mapRepairsAsSummary(RepairEntity repairEntity) {

        RecentRepairsDTO recentRepairsDTO = new RecentRepairsDTO()
                .setRepairName(repairEntity.getName())
                .setRepairParts(repairEntity.getParts())
                .setDate(String.valueOf(repairEntity.getDateCreated()))
                .setRepairImageUrl(repairEntity.getImage());



        return recentRepairsDTO;
    }

    private RepairEntity map(RecentRepairsDTO recentRepairsDTO) {

        RepairEntity newRepair = new RepairEntity()
                .setName(recentRepairsDTO.getRepairName())
                .setImage(recentRepairsDTO.getRepairImageUrl())
                .setDateCreated(recentRepairsDTO.getDate())
                .setParts(recentRepairsDTO.getRepairParts());



        return newRepair;
    }

    private void addPartIfPresent(List<PartEntity> newParts, String partName, String partDescription, BigDecimal partPrice, int partQuantity, CarEntity carEntity, RepairEntity newRepair) {
        if (partName != null && !partName.isEmpty()) {
            PartEntity part = new PartEntity()
                    .setName(partName)
                    .setDescription(partDescription)
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

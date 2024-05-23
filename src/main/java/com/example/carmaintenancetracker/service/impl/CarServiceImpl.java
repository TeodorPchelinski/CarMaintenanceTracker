package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CarSummaryDTO;
import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.repository.CarRepository;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.CarService;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final UserRepository userRepository;
    private UserService userService;
    private final CarRepository carRepository;


    public CarServiceImpl(UserRepository userRepository, UserService userService,
                          CarRepository carRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.carRepository = carRepository;
    }


    @Override
    public Long createCar(CreateCarDTO createCarDTO, UserDetails creator) {

        // unlogged user can't create car because he won't be allowed to be on Create Car page or My Garage page

        CarEntity newCar = map(createCarDTO);
        // all inputs from the site as createCarDTO

        //todo: test what type of String comes



        UserEntity ownerEntity = userRepository.findByEmail(creator.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User with email " + creator.getUsername() + "not found!"));

        newCar.setOwner(ownerEntity);

        newCar = carRepository.save(newCar);

        if (createCarDTO.getImage() != null) {
            MultipartFile imageName = createCarDTO.getImage();

            try {
                String filePath = ".\\src\\main\\resources\\static\\images\\users\\" + creator.getUsername() + "\\cars\\" + newCar.getId() + ".jpg";
                File file = new File(filePath);

                file.getParentFile().mkdirs();
                file.createNewFile();

                OutputStream outputStream = new FileOutputStream(file);
                outputStream.write(imageName.getBytes());

                newCar.setImage(filePath);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


        //todo: HTML page for the newly created car
        return newCar.getId();
    }

    @Override
    public List<CarEntity> getCarsByOwner(UserEntity owner) {
        return null;
    }


    //             CARS LIST
    @Override
    public Page<CarSummaryDTO> getAllCarsByOwnerId(Pageable pageable, UserDetails creator) {

        Optional<UserEntity> owner = userRepository.findByEmail(creator.getUsername());
        if (!owner.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }


        return carRepository.findAllByOwnerId(owner.get().getId(), pageable).map(CarServiceImpl::mapAsSummary);
    }

    private static CarSummaryDTO mapAsSummary(CarEntity carEntity) {
         //  Brand is String In CarEntity and in CarSummaryDTO
         //  Year is LocalDate in CarEntity and in CarSummaryDTO
        return new CarSummaryDTO(
                carEntity.getBrand(),
                carEntity.getModel(),
                carEntity.getEngineDisplacement(),
                carEntity.getManufactureYear(),
                carEntity.getFuelType(),
                carEntity.getTransmission());
    }

    private CarEntity map(CreateCarDTO createCarDTO) {

        CarEntity newCar = new CarEntity()
                .setModel(createCarDTO.getModel())
                .setBrand(createCarDTO.getBrand())
                .setManufactureYear(
                        LocalDate.of(createCarDTO.getManufactureYear(), Month.of(createCarDTO.getManufactureMonth()), 1))
                .setFuelType(createCarDTO.getFuelEngineType())
                .setEngineDisplacement(createCarDTO.getEngineDisplacement())
                .setTransmission( createCarDTO.getTransmission())
                .setMileage(createCarDTO.getMileage());


         return newCar;
    }

//    @Override
//    public Page<CarSummaryDTO> getAllCarsByOwnerId(Pageable pageable, UserDetails creator) {
//
//        //todo: like UserRepository make it get current user's id and giving all his cars
//
//        //Get UserEntity user_id from  getUserWithEmail(creatorUsername);
//        //Get CarEntity owner_id with getOwnerId(user_id);
//
//        //todo: How to add cars shared to this user
//
//
//        UserEntity ownerEntity = userRepository.findByEmail(creator.getUsername())
//                .orElseThrow(() -> new IllegalArgumentException("User with email " + creator.getUsername() + "not found!"));
//
//
//        //todo: Make the findBy(ownerId) + pageable, map(CarServiceImpl::mapAsSummary) -> how to convert first line as acceptable type to second line
//        Page<CarEntity> carsOwnedByUser = carRepository.findAllByOwnerId(ownerEntity.getId(), pageable);

//
////        Page<CarSummaryDTO> carSummaries = carsOwnedByUser.map(CarServiceImpl::mapAsSummary);
//
//        return carSummaries;
//    }



}
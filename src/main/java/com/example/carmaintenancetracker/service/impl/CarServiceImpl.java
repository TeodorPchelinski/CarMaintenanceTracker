package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.CarSummaryDTO;
import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.repository.CarRepository;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.CarService;
import com.example.carmaintenancetracker.service.UserService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private UserRepository userRepository;
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

                newCar.setImage("\\images\\users\\" + creator.getUsername() + "\\cars\\" + newCar.getId() + ".jpg");

                carRepository.save(newCar);

                //todo: How to end the process right after saving new image.
                //      After creation images are broken but after restart of the whole server they are fine.

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        //todo: Adding "rembg" or "U-2-Net" for server side background removal






        //todo: HTML page for the newly created car
        return newCar.getId();
    }



    @Transactional
    @Override
    public void deleteCarById(Long id){

        CarEntity carEntity = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car with that id was not found:" + id));

        UserEntity owner = carEntity.getOwner();


        String filePath = ".\\src\\main\\resources\\static\\images\\users\\" + owner.getEmail() + "\\cars\\" + id + ".jpg";

        //todo: Delete image can't it is used in other process
//        Path path = Paths.get(filePath);
//
//        try{
//            if (Files.exists(path)){
//                Files.delete(path);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        carRepository.deleteCarEntityById(id);
    }

    @Override
    public Page<CarSummaryDTO> getAllCars(Pageable pageable) {

        return carRepository.findAll(pageable).map(CarServiceImpl::mapAsSummary);
    }



    //             CARS LIST
    @Override
    public Page<CarSummaryDTO> getAllCarsByOwnerId(Pageable pageable, UserDetails creator) {

        Optional<UserEntity> owner = userRepository.findByEmail(creator.getUsername());
        if (!owner.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }


        Long number = owner.get().getId();
        return carRepository.findAllCarsByOwnerId(number, pageable).map(CarServiceImpl::mapAsSummary);
    }


    @Override
    public CarEntity findCarById(Long id) {

        return carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car not found with id: " + id));
    }

    private static CarSummaryDTO mapAsSummary(CarEntity carEntity) {
         //  Brand is String In CarEntity and in CarSummaryDTO
         //  Year is LocalDate in CarEntity and in CarSummaryDTO

        CarSummaryDTO carSummaryDTO = new CarSummaryDTO()
                .setId(carEntity.getId())
                .setImage(carEntity.getImage())
                .setBrand(carEntity.getBrand())
                .setModel(carEntity.getModel())
                .setEngineDisplacement(String.format(Locale.US, "%.1f" + "L", carEntity.getEngineDisplacement() * 0.001))
                .setYear(carEntity.getManufactureYear().getYear())
                .setFuelEnum(carEntity.getFuelType())
                .setTransmissionEnum(carEntity.getTransmission());


        System.out.println(carSummaryDTO);
        return carSummaryDTO;
    }

    //private static CarDetailsDTO

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



      //todo: How to add cars shared to this user




}

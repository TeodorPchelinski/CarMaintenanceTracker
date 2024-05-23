package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.dto.CarSummaryDTO;
import com.example.carmaintenancetracker.model.dto.CreateCarDTO;
import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface CarService {

    Long createCar(CreateCarDTO createCarDTO, UserDetails creator);

    //todo: remove getCarsByOwner if pageable did the same work better
    List<CarEntity> getCarsByOwner(UserEntity owner);

    Page<CarSummaryDTO> getAllCarsByOwnerId(Pageable pageable, UserDetails creator);
}

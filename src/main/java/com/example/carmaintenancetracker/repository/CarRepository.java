package com.example.carmaintenancetracker.repository;

import com.example.carmaintenancetracker.model.entity.CarEntity;
import com.example.carmaintenancetracker.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    List<CarEntity> findAllByOwner(UserEntity owner);

    Page<CarEntity> findAll(Pageable pageable);
    Page<CarEntity> findAllCarsByOwnerId(Long valueOf, Pageable pageable);
    // No need of Page here -> I have a list already

    //todo: When safeDelete Car one problem occurs How to store all history with it
    //      id 1 in Cars -> moved to DeletedCars with (id 1) stored as Previous Id in column (PreviousId)
    //      when restored the carId should be change with the new auto-generated (id 7)
    //      in parts, documents, refuels connected with this car

    void deleteCarEntityById(Long id);
    // delete function will be in page deleted cars
    // before this will be remove function which will transfer the car to a list of deleted cars

}

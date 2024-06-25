package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.OneToMany;

import java.util.List;

public class RepairEntity extends BaseEntity {

    private String name;

    @OneToMany()
    private List<PartEntity> parts;

}

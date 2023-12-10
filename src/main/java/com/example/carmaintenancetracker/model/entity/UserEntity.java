package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    @NotBlank
    private String name;

    @Column(unique = true, nullable = false)
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<CarEntity> cars;
}

package com.example.carmaintenancetracker.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {


    //todo: add username -> not all people want to be with their real names

    @Column(nullable = false)
    @NotBlank
    private String firstName;

    @Column(nullable = false)
    @NotBlank
    private String lastName;

    @Column(unique = true, nullable = false)
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    @Column
    private List<CarEntity> cars;


    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<CarEntity> getCars() {
        return cars;
    }

    public UserEntity setCars(List<CarEntity> cars) {
        this.cars = cars;
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}

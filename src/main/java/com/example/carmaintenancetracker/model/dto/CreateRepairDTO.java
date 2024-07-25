package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.entity.GpsCoordinatesEntity;
import com.example.carmaintenancetracker.model.entity.PartEntity;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CreateRepairDTO {

    private Long carId;

    private String repairTitle;

    private LocalDate dateSelected;

    private List<PartEntity> parts;

    // When select existing Service
    private Long serviceId;
    //todo: If new Service is created set serviceId to null

    private String serviceName;

    private GpsCoordinatesEntity serviceLocation;

    private MultipartFile serviceImage;

    private String description;

    // When select existing Shop
    private Long shopId;

    private String shopName;

    private GpsCoordinatesEntity shopLocation;

    private MultipartFile shopImage;

    //todo: 2 shops

    private BigDecimal totalCost;

    public CreateRepairDTO(Long id, String repairTitle, LocalDate dateSelected, List<PartEntity> parts, Long serviceId,
                           String serviceName, GpsCoordinatesEntity serviceLocation, MultipartFile serviceImage,
                           String description, Long shopId, String shopName, GpsCoordinatesEntity shopLocation,
                           MultipartFile shopImage, BigDecimal totalCost) {
        this.carId = id;
        this.repairTitle = repairTitle;
        this.dateSelected = dateSelected;
        this.parts = parts;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceLocation = serviceLocation;
        this.serviceImage = serviceImage;
        this.description = description;
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopLocation = shopLocation;
        this.shopImage = shopImage;
        this.totalCost = totalCost;
    }

    public CreateRepairDTO() {

    }

    public Long getCarId() {
        return carId;
    }

    public CreateRepairDTO setCarId(Long carId) {
        this.carId = carId;
        return this;
    }

    public String getRepairTitle() {
        return repairTitle;
    }

    public CreateRepairDTO setRepairTitle(String repairTitle) {
        this.repairTitle = repairTitle;
        return this;
    }

    public LocalDate getDateSelected() {
        return dateSelected;
    }

    public CreateRepairDTO setDateSelected(LocalDate dateSelected) {
        this.dateSelected = dateSelected;
        return this;
    }

    public List<PartEntity> getParts() {
        return parts;
    }

    public CreateRepairDTO setParts(List<PartEntity> parts) {
        this.parts = parts;
        return this;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public CreateRepairDTO setServiceId(Long serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public CreateRepairDTO setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public GpsCoordinatesEntity getServiceLocation() {
        return serviceLocation;
    }

    public CreateRepairDTO setServiceLocation(GpsCoordinatesEntity serviceLocation) {
        this.serviceLocation = serviceLocation;
        return this;
    }

    public MultipartFile getServiceImage() {
        return serviceImage;
    }

    public CreateRepairDTO setServiceImage(MultipartFile serviceImage) {
        this.serviceImage = serviceImage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateRepairDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getShopId() {
        return shopId;
    }

    public CreateRepairDTO setShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public String getShopName() {
        return shopName;
    }

    public CreateRepairDTO setShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public GpsCoordinatesEntity getShopLocation() {
        return shopLocation;
    }

    public CreateRepairDTO setShopLocation(GpsCoordinatesEntity shopLocation) {
        this.shopLocation = shopLocation;
        return this;
    }

    public MultipartFile getShopImage() {
        return shopImage;
    }

    public CreateRepairDTO setShopImage(MultipartFile shopImage) {
        this.shopImage = shopImage;
        return this;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public CreateRepairDTO setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
        return this;
    }
}

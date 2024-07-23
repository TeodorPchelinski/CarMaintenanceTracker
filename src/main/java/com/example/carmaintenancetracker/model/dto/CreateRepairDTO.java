package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.entity.GpsCoordinatesEntity;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateRepairDTO {

    private Long carId;

    private String repairTitle;

    private LocalDate dateSelected;

    private String partName;

    private BigDecimal partPrice;

    private int quantity;

    private String partName2;

    private BigDecimal partPrice2;

    private int quantity2;

    private String partName3;

    private BigDecimal partPrice3;

    private int quantity3;

    private String partName4;

    private BigDecimal partPrice4;

    private int quantity4;

    private String partName5;

    private BigDecimal partPrice5;

    private int quantity5;

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

    private BigDecimal totalCost;

    public CreateRepairDTO(Long id, String repairTitle, LocalDate dateSelected, String partName, BigDecimal partPrice,
                           int quantity, String partName2, BigDecimal partPrice2, int quantity2, String partName3,
                           BigDecimal partPrice3, int quantity3, String partName4, BigDecimal partPrice4,
                           int quantity4, String partName5, BigDecimal partPrice5, int quantity5, Long serviceId,
                           String serviceName, GpsCoordinatesEntity serviceLocation, MultipartFile serviceImage,
                           String description, Long shopId, String shopName, GpsCoordinatesEntity shopLocation,
                           MultipartFile shopImage, BigDecimal totalCost) {
        this.carId = id;
        this.repairTitle = repairTitle;
        this.dateSelected = dateSelected;
        this.partName = partName;
        this.partPrice = partPrice;
        this.quantity = quantity;
        this.partName2 = partName2;
        this.partPrice2 = partPrice2;
        this.quantity2 = quantity2;
        this.partName3 = partName3;
        this.partPrice3 = partPrice3;
        this.quantity3 = quantity3;
        this.partName4 = partName4;
        this.partPrice4 = partPrice4;
        this.quantity4 = quantity4;
        this.partName5 = partName5;
        this.partPrice5 = partPrice5;
        this.quantity5 = quantity5;
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

    public String getPartName() {
        return partName;
    }

    public CreateRepairDTO setPartName(String partName) {
        this.partName = partName;
        return this;
    }

    public BigDecimal getPartPrice() {
        return partPrice;
    }

    public CreateRepairDTO setPartPrice(BigDecimal partPrice) {
        this.partPrice = partPrice;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public CreateRepairDTO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getPartName2() {
        return partName2;
    }

    public CreateRepairDTO setPartName2(String partName2) {
        this.partName2 = partName2;
        return this;
    }

    public BigDecimal getPartPrice2() {
        return partPrice2;
    }

    public CreateRepairDTO setPartPrice2(BigDecimal partPrice2) {
        this.partPrice2 = partPrice2;
        return this;
    }

    public int getQuantity2() {
        return quantity2;
    }

    public CreateRepairDTO setQuantity2(int quantity2) {
        this.quantity2 = quantity2;
        return this;
    }

    public String getPartName3() {
        return partName3;
    }

    public CreateRepairDTO setPartName3(String partName3) {
        this.partName3 = partName3;
        return this;
    }

    public BigDecimal getPartPrice3() {
        return partPrice3;
    }

    public CreateRepairDTO setPartPrice3(BigDecimal partPrice3) {
        this.partPrice3 = partPrice3;
        return this;
    }

    public int getQuantity3() {
        return quantity3;
    }

    public CreateRepairDTO setQuantity3(int quantity3) {
        this.quantity3 = quantity3;
        return this;
    }

    public String getPartName4() {
        return partName4;
    }

    public CreateRepairDTO setPartName4(String partName4) {
        this.partName4 = partName4;
        return this;
    }

    public BigDecimal getPartPrice4() {
        return partPrice4;
    }

    public CreateRepairDTO setPartPrice4(BigDecimal partPrice4) {
        this.partPrice4 = partPrice4;
        return this;
    }

    public int getQuantity4() {
        return quantity4;
    }

    public CreateRepairDTO setQuantity4(int quantity4) {
        this.quantity4 = quantity4;
        return this;
    }

    public String getPartName5() {
        return partName5;
    }

    public CreateRepairDTO setPartName5(String partName5) {
        this.partName5 = partName5;
        return this;
    }

    public BigDecimal getPartPrice5() {
        return partPrice5;
    }

    public CreateRepairDTO setPartPrice5(BigDecimal partPrice5) {
        this.partPrice5 = partPrice5;
        return this;
    }

    public int getQuantity5() {
        return quantity5;
    }

    public CreateRepairDTO setQuantity5(int quantity5) {
        this.quantity5 = quantity5;
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

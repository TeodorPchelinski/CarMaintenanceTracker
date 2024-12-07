package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.entity.GpsCoordinatesEntity;
import com.example.carmaintenancetracker.model.entity.PartEntity;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CreateRepairDTO {


    private String carId;

    private String repairTitle;

    private MultipartFile image;

    private LocalDate dateSelected;

    private String partName1;

    private String partName2;

    private String partName3;

    private String partName4;

    private String partDescription1;

    private String partDescription2;

    private String partDescription3;

    private String partDescription4;

    private BigDecimal partPrice1;

    private BigDecimal partPrice2;

    private BigDecimal partPrice3;

    private BigDecimal partPrice4;

    private int partQuantity1;

    private int partQuantity2;

    private int partQuantity3;

    private int partQuantity4;

    private String serviceName;

    private String latitude;

    private String longitude;

//    private GpsCoordinatesEntity serviceLocation;

//    private MultipartFile serviceImage;

    private String description;

    // When select existing Shop
//    private Long shopId;

    private String shopName;

//    private GpsCoordinatesEntity shopLocation;

//    private MultipartFile shopImage;

    private BigDecimal totalCost;

    public CreateRepairDTO(String carId, String repairTitle, MultipartFile image, LocalDate dateSelected,
                           String partName1, String partName2, String partName3, String partName4,
                           String partDescription1, String partDescription2, String partDescription3, String partDescription4,
                           BigDecimal partPrice1, BigDecimal partPrice2, BigDecimal partPrice3,
                           BigDecimal partPrice4, int partQuantity1, int partQuantity2, int partQuantity3,
                           int partQuantity4, String serviceName, String description, String shopName, BigDecimal totalCost,
                            String latitude, String longitude) {
        this.carId = carId;
        this.repairTitle = repairTitle;
        this.image = image;
        this.dateSelected = dateSelected;
        this.partName1 = partName1;
        this.partName2 = partName2;
        this.partName3 = partName3;
        this.partName4 = partName4;
        this.partDescription1 = partDescription1;
        this.partDescription2 = partDescription2;
        this.partDescription3 = partDescription3;
        this.partDescription4 = partDescription4;
        this.partPrice1 = partPrice1;
        this.partPrice2 = partPrice2;
        this.partPrice3 = partPrice3;
        this.partPrice4 = partPrice4;
        this.partQuantity1 = partQuantity1;
        this.partQuantity2 = partQuantity2;
        this.partQuantity3 = partQuantity3;
        this.partQuantity4 = partQuantity4;
        this.serviceName = serviceName;
        this.description = description;
        this.shopName = shopName;
        this.totalCost = totalCost;
        this.latitude = latitude;
        this.longitude = longitude;
    }



    public String getCarId() {
        return carId;
    }

    public CreateRepairDTO setCarId(String carId) {
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

    public MultipartFile getImage() {
        return image;
    }

    public CreateRepairDTO setImage(MultipartFile image) {
        this.image = image;
        return this;
    }

    public LocalDate getDateSelected() {
        return dateSelected;
    }

    public CreateRepairDTO setDateSelected(LocalDate dateSelected) {
        this.dateSelected = dateSelected;
        return this;
    }

    public String getPartName1() {
        return partName1;
    }

    public CreateRepairDTO setPartName1(String partName1) {
        this.partName1 = partName1;
        return this;
    }

    public String getPartName2() {
        return partName2;
    }

    public CreateRepairDTO setPartName2(String partName2) {
        this.partName2 = partName2;
        return this;
    }

    public String getPartName3() {
        return partName3;
    }

    public CreateRepairDTO setPartName3(String partName3) {
        this.partName3 = partName3;
        return this;
    }

    public String getPartName4() {
        return partName4;
    }

    public CreateRepairDTO setPartName4(String partName4) {
        this.partName4 = partName4;
        return this;
    }

    public String getPartDescription1() {
        return partDescription1;
    }

    public CreateRepairDTO setPartDescription1(String partDescription1) {
        this.partDescription1 = partDescription1;
        return this;
    }

    public String getPartDescription2() {
        return partDescription2;
    }

    public CreateRepairDTO setPartDescription2(String partDescription2) {
        this.partDescription2 = partDescription2;
        return this;
    }

    public String getPartDescription3() {
        return partDescription3;
    }

    public CreateRepairDTO setPartDescription3(String partDescription3) {
        this.partDescription3 = partDescription3;
        return this;
    }

    public String getPartDescription4() {
        return partDescription4;
    }

    public CreateRepairDTO setPartDescription4(String partDescription4) {
        this.partDescription4 = partDescription4;
        return this;
    }

    public BigDecimal getPartPrice1() {
        return partPrice1;
    }

    public CreateRepairDTO setPartPrice1(BigDecimal partPrice1) {
        this.partPrice1 = partPrice1;
        return this;
    }

    public BigDecimal getPartPrice2() {
        return partPrice2;
    }

    public CreateRepairDTO setPartPrice2(BigDecimal partPrice2) {
        this.partPrice2 = partPrice2;
        return this;
    }

    public BigDecimal getPartPrice3() {
        return partPrice3;
    }

    public CreateRepairDTO setPartPrice3(BigDecimal partPrice3) {
        this.partPrice3 = partPrice3;
        return this;
    }

    public BigDecimal getPartPrice4() {
        return partPrice4;
    }

    public CreateRepairDTO setPartPrice4(BigDecimal partPrice4) {
        this.partPrice4 = partPrice4;
        return this;
    }

    public int getPartQuantity1() {
        return partQuantity1;
    }

    public CreateRepairDTO setPartQuantity1(int partQuantity1) {
        this.partQuantity1 = partQuantity1;
        return this;
    }

    public int getPartQuantity2() {
        return partQuantity2;
    }

    public CreateRepairDTO setPartQuantity2(int partQuantity2) {
        this.partQuantity2 = partQuantity2;
        return this;
    }

    public int getPartQuantity3() {
        return partQuantity3;
    }

    public CreateRepairDTO setPartQuantity3(int partQuantity3) {
        this.partQuantity3 = partQuantity3;
        return this;
    }

    public int getPartQuantity4() {
        return partQuantity4;
    }

    public CreateRepairDTO setPartQuantity4(int partQuantity4) {
        this.partQuantity4 = partQuantity4;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public CreateRepairDTO setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }




    public String getDescription() {
        return description;
    }

    public CreateRepairDTO setDescription(String description) {
        this.description = description;
        return this;
    }



    public String getShopName() {
        return shopName;
    }

    public CreateRepairDTO setShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }


    public String getLatitude() {
        return latitude;
    }

    public CreateRepairDTO setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public CreateRepairDTO setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public CreateRepairDTO setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    @Override
    public String toString() {
        return "CreateRepairDTO{" +
                "carId=" + carId +
                ", repairTitle='" + repairTitle + '\'' +
                ", dateSelected=" + dateSelected +
                ", partName1='" + partName1 + '\'' +
                ", partName2='" + partName2 + '\'' +
                ", partName3='" + partName3 + '\'' +
                ", partName4='" + partName4 + '\'' +
                ", partPrice1=" + partPrice1 +
                ", partPrice2=" + partPrice2 +
                ", partPrice3=" + partPrice3 +
                ", partPrice4=" + partPrice4 +
                ", partDescription1=" + partDescription1 +
                ", partDescription2=" + partDescription2 +
                ", partDescription3=" + partDescription3 +
                ", partDescription4=" + partDescription4 +
                ", partQuantity1=" + partQuantity1 +
                ", partQuantity2=" + partQuantity2 +
                ", partQuantity3=" + partQuantity3 +
                ", partQuantity4=" + partQuantity4 +
                ", serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                ", shopName='" + shopName + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}

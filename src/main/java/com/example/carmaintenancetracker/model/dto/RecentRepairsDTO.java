package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.entity.PartEntity;

import java.time.LocalDate;
import java.util.List;

public class RecentRepairsDTO {

    String repairImageUrl;

    String repairName;

    List<PartEntity> repairParts;

    String date;

    public RecentRepairsDTO() {
        this.repairImageUrl = repairImageUrl;
        this.repairName = repairName;
        this.repairParts = repairParts;
        this.date = date;
    }

    public String getRepairImageUrl() {
        return repairImageUrl;
    }

    public RecentRepairsDTO setRepairImageUrl(String repairImageUrl) {
        this.repairImageUrl = repairImageUrl;
        return this;
    }

    public String getRepairName() {
        return repairName;
    }

    public RecentRepairsDTO setRepairName(String repairName) {
        this.repairName = repairName;
        return this;
    }

    public List<PartEntity> getRepairParts() {
        return repairParts;
    }

    public RecentRepairsDTO setRepairParts(List<PartEntity> repairParts) {
        this.repairParts = repairParts;
        return this;
    }

    public LocalDate getDate() {
        return LocalDate.parse(date);
    }

    public RecentRepairsDTO setDate(String date) {
        this.date = date;
        return this;
    }
}

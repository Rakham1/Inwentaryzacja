package com.thesis.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.security.Timestamp;
import java.util.Date;

public class InventoryDTO {
    private Long id;
    private String inventoryNumber;
    private String committeeSquad;
    private Long personId;
    private Long warehouseId;
    private String comment;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    private Date invDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getCommitteeSquad() {
        return committeeSquad;
    }

    public void setCommitteeSquad(String committeeSquad) {
        this.committeeSquad = committeeSquad;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }
}

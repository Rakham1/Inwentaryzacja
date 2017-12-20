package com.thesis.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.security.Timestamp;

public class InventoryDTO {
    private Long id;
    private String inventoryNumber;
    private String committeeSquad;
    private Long personId;
    private String comment;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

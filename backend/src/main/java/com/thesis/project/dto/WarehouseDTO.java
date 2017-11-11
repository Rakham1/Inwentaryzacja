package com.thesis.project.dto;

public class WarehouseDTO {
    private long id;
    private String name;
    FirmDTO firm;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FirmDTO getFirm() {
        return firm;
    }

    public void setFirm(FirmDTO firm) {
        this.firm = firm;
    }
}

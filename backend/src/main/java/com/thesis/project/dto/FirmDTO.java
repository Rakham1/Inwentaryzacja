package com.thesis.project.dto;

import java.util.Collection;

public class FirmDTO {
    private long id;
    private String firmName;
    private String street;
    private String city;
    private String postcode;
    private int nip;
    private Collection<WarehouseDTO> warehouses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public Collection<WarehouseDTO> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Collection<WarehouseDTO> warehouses) {
        this.warehouses = warehouses;
    }
}

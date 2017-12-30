package com.thesis.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Firm")
public class Firm {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long firmId;

    @OneToOne
    private Person user;

    @Column(name = "firmname")
    private String firmName;

    @Column(name = "postCode")
    private String postCode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "nip")
    private String nip;

    @OneToMany(mappedBy = "firm")
    @Column(name = "warehouse", nullable = true)
    private Set<Warehouse> warehouse = new HashSet<>();

    @OneToMany(mappedBy = "firm")
    private Set<Contractor> contractors = new HashSet<>();

    public Long getFirmId() {
        return firmId;
    }

    @JsonIgnore
    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    @JsonIgnore
    public Set<Warehouse> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Set<Warehouse> warehouse) {
        this.warehouse = warehouse;
    }

    public void setFirmId(Long firmId) {
        this.firmId = firmId;
    }

    public Set<Contractor> getContractors() {
        return contractors;
    }

    public void setContractors(Set<Contractor> contractors) {
        this.contractors = contractors;
    }
}

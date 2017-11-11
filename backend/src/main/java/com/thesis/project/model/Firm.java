package com.thesis.project.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Firm")
public class Firm {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long firmId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Person user;

    @Column(name = "firmname")
    private String firmName;

    @Column(name = "postCode")
    private String postCode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name="nip")
    private int nip;

    @OneToMany(mappedBy = "firm")
    @Column(name = "warehouse")
    private Set<Warehouse> warehouse = new HashSet<>();

    public long getFirmId() {
        return firmId;
    }

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

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public Set<Warehouse> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Set<Warehouse> warehouse) {
        this.warehouse = warehouse;
    }

    public void setFirmId(long firmId) {
        this.firmId = firmId;


    }
}

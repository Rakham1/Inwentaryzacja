package com.thesis.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Contractor")
public class Contractor {
    @Id
    @GeneratedValue
    private Long id;

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

    @OneToMany(mappedBy = "contractor")
    private Set<StorageDepot> storageDepots = new HashSet<>();

    @OneToMany(mappedBy = "contractor")
    private Set<ItemRelease> itemReleases = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "firm_id")
    private Firm firm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<StorageDepot> getStorageDepots() {
        return storageDepots;
    }

    public void setStorageDepots(Set<StorageDepot> storageDepots) {
        this.storageDepots = storageDepots;
    }

    @JsonIgnore
    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public Set<ItemRelease> getItemReleases() {
        return itemReleases;
    }

    public void setItemReleases(Set<ItemRelease> itemReleases) {
        this.itemReleases = itemReleases;
    }
}

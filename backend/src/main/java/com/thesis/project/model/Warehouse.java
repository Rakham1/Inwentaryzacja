package com.thesis.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Warehouse")
public class Warehouse {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "firm_id", nullable = false)
    private Firm firm;

    @Column(name = "name")
    private String name;

    @Column(name = "postCode")
    private String postCode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @OneToMany(mappedBy = "warehouse")
    private Set<WarIt> warIts = new HashSet<>();

    @OneToMany(mappedBy ="warehouse")
    private Set<WarInv> warInvs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @JsonIgnore
    public Set<WarIt> getWarIts() {
        return warIts;
    }

    public void setWarIts(Set<WarIt> warIts) {
        this.warIts = warIts;
    }

    public Set<WarInv> getWarInvs() {
        return warInvs;
    }

    public void setWarInvs(Set<WarInv> warInvs) {
        this.warInvs = warInvs;
    }
}

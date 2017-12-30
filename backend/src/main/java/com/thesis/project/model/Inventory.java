package com.thesis.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private Long id;

    private String inventoryNumber;

    private String committeeSquad;

    @Column(name = "inv_Date")
    private Date invDate;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Person user;

    @OneToMany(mappedBy = "inventory")
    private Set<InvIte> invItes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="warehouse_id")
    private Warehouse warehouse;

//    public Timestamp getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Timestamp timestamp) {
//        this.timestamp = timestamp;
//    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    @JsonIgnore
    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }
    @JsonIgnore
    public Set<InvIte> getInvItes() {
        return invItes;
    }

    public void setInvItes(Set<InvIte> invItes) {
        this.invItes = invItes;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}


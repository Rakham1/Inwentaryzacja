package com.thesis.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private Long id;

    private String inventoryNumber;

    private String committeeSquad;

    @OneToMany(mappedBy = "inventory")
    private Set<WarInv> warInvs = new HashSet<>();
//
//    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private Timestamp timestamp;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Person user;

    @OneToMany(mappedBy = "inventory")
    private Set<InvIte> invItes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Timestamp getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Timestamp timestamp) {
//        this.timestamp = timestamp;
//    }

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

    public Set<WarInv> getWarInvs() {
        return warInvs;
    }

    public void setWarInvs(Set<WarInv> warInvs) {
        this.warInvs = warInvs;
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

    public Set<InvIte> getInvItes() {
        return invItes;
    }

    public void setInvItes(Set<InvIte> invItes) {
        this.invItes = invItes;
    }
}


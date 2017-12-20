package com.thesis.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "price")
    private Long price;

    @Column(name = "unit")
    private String unit;

    @Column(name = "barcode", nullable = true)
    private String barcode;

    @Column(name = "notes")
    private String notes;

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;

    @OneToMany(mappedBy = "item")
    private Set<WarIt> warIts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "item")
    private Set<InvIte> invItes = new HashSet<>();

//    @ManyToMany(mappedBy = "item", fetch = FetchType.EAGER)
//    private Set<InHistory> inHistory = new HashSet<>();
//
//    @ManyToMany(mappedBy = "item", fetch = FetchType.EAGER)
//    private Set<OutHistory> outHistory = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Set<WarIt> getWarIts() {
        return warIts;
    }

    @JsonIgnore
    public void setWarIts(Set<WarIt> warIts) {
        this.warIts = warIts;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

//    public Set<InHistory> getInHistory() {
//        return inHistory;
//    }
//
//    public void setInHistory(Set<InHistory> inHistory) {
//        this.inHistory = inHistory;
//    }
//
//    public Set<OutHistory> getOutHistory() {
//        return outHistory;
//    }
//
//    public void setOutHistory(Set<OutHistory> outHistory) {
//        this.outHistory = outHistory;
//    }


    public Set<InvIte> getInvItes() {
        return invItes;
    }
    @JsonIgnore
    public void setInvItes(Set<InvIte> invItes) {
        this.invItes = invItes;
    }
}

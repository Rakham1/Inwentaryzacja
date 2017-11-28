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
    private long id;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "productIndex")
    private int index;

    @Column(name = "stock")
    private int stock;

    @Column(name = "minStock")
    private int minStock;

    @Column(name = "maxStock")
    private int maxStock;

    @Column(name = "price")
    private long price;

    @Column(name = "unit")
    private String unit;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;

    @ManyToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private Set<Warehouse> warehouse = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private Set<InHistory> inHistory = new HashSet<>();

    @ManyToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private Set<OutHistory> outHistory = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
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

    public Set<Warehouse> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Set<Warehouse> warehouse) {
        this.warehouse = warehouse;
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
    @JsonIgnore
    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<InHistory> getInHistory() {
        return inHistory;
    }

    public void setInHistory(Set<InHistory> inHistory) {
        this.inHistory = inHistory;
    }

    public Set<OutHistory> getOutHistory() {
        return outHistory;
    }

    public void setOutHistory(Set<OutHistory> outHistory) {
        this.outHistory = outHistory;
    }
}

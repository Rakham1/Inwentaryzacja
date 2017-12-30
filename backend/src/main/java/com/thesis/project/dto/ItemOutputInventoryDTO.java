package com.thesis.project.dto;

import com.thesis.project.model.InvIte;
import com.thesis.project.model.Warehouse;

import java.util.ArrayList;
import java.util.Set;

public class ItemOutputInventoryDTO {
    private Long id;
    private String itemName;
    private String description;
    private Integer stock;
    private String unit;
    private Set<InvIte> invItes;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Set<InvIte> getInvItes() {
        return invItes;
    }

    public void setInvItes(Set<InvIte> invItes) {
        this.invItes = invItes;
    }
}

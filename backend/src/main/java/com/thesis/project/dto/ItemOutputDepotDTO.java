package com.thesis.project.dto;

import com.thesis.project.model.DepIt;
import javafx.scene.effect.SepiaTone;

import java.util.Set;

public class ItemOutputDepotDTO {
    private Long id;
    private String itemName;
    private String description;
    private String unit;
    private Long price;
    private Set<DepIt> depItSet;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Set<DepIt> getDepItSet() {
        return depItSet;
    }

    public void setDepItSet(Set<DepIt> depItSet) {
        this.depItSet = depItSet;
    }
}

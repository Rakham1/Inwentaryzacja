package com.thesis.project.dto;

import com.thesis.project.model.ItemRelease;
import com.thesis.project.model.RelIt;

import java.util.Set;

public class ItemOutputReleaseDTO {
    private Long id;
    private String itemName;
    private String description;
    private Integer stock;
    private String unit;
    private Long price;
    private Set<RelIt> relIts;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Set<RelIt> getRelIts() {
        return relIts;
    }

    public void setRelIts(Set<RelIt> relIts) {
        this.relIts = relIts;
    }
}

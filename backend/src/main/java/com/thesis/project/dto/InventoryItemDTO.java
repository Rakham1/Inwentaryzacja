package com.thesis.project.dto;

public class InventoryItemDTO {
    private Long inventoryId;
    private Long itemId;
    private Integer amount;

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

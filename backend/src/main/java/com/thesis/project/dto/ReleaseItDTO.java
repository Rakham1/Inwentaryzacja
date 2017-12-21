package com.thesis.project.dto;

public class ReleaseItDTO {
    private Long itemReleaseId;
    private Long itemId;
    private Integer amount;

    public Long getItemReleaseId() {
        return itemReleaseId;
    }

    public void setItemReleaseId(Long itemReleaseId) {
        this.itemReleaseId = itemReleaseId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

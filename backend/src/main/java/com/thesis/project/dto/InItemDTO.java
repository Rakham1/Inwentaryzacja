package com.thesis.project.dto;

import java.util.Collection;

public class InItemDTO {
    private Collection<InHistoryDTO> inHistories;
    private Collection<ItemDTO> items;

    public Collection<InHistoryDTO> getInHistories() {
        return inHistories;
    }

    public void setInHistories(Collection<InHistoryDTO> inHistories) {
        this.inHistories = inHistories;
    }

    public Collection<ItemDTO> getItems() {
        return items;
    }

    public void setItems(Collection<ItemDTO> items) {
        this.items = items;
    }
}

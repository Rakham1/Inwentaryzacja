package dto;

import model.Item;

import java.util.Collection;

public class OutItemDTO {
    private Collection<Item> items;
    private Collection<OutHistoryDTO> outHistories;

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Collection<OutHistoryDTO> getOutHistories() {
        return outHistories;
    }

    public void setOutHistories(Collection<OutHistoryDTO> outHistories) {
        this.outHistories = outHistories;
    }
}

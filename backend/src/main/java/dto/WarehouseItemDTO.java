package dto;

import java.util.Collection;

public class WarehouseItemDTO {
    private Collection<WarehouseDTO> warehouses;
    private Collection<ItemDTO> items;

    public Collection<WarehouseDTO> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Collection<WarehouseDTO> warehouses) {
        this.warehouses = warehouses;
    }

    public Collection<ItemDTO> getItems() {
        return items;
    }

    public void setItems(Collection<ItemDTO> items) {
        this.items = items;
    }
}

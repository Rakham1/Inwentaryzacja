package dto;

import java.util.Collection;

public class ItemDTO {
    private long itemId;
    private String itemName;
    private String description;
    private long index;
    private int stock;
    private String unit;
    private int minStock;
    private int maxStock;
    private String barcode;
    private Collection<WarehouseDTO> warehouse;
    private Collection<GroupDTO> group;
    private Collection<TypeDTO> type;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
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

    public void setIndex(long index) {
        this.index = index;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Collection<WarehouseDTO> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Collection<WarehouseDTO> warehouse) {
        this.warehouse = warehouse;
    }

    public Collection<GroupDTO> getGroup() {
        return group;
    }

    public void setGroup(Collection<GroupDTO> group) {
        this.group = group;
    }

    public Collection<TypeDTO> getType() {
        return type;
    }

    public void setType(Collection<TypeDTO> type) {
        this.type = type;
    }

}

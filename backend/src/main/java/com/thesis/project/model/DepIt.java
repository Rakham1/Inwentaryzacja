package com.thesis.project.model;

import javax.persistence.*;

@Entity
@Table(name = "DepositItem")
public class DepIt {
    @Id
    @GeneratedValue
    private Long id;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "depot_id")
    private StorageDepot storageDepot;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public StorageDepot getStorageDepot() {
        return storageDepot;
    }

    public void setStorageDepot(StorageDepot storageDepot) {
        this.storageDepot = storageDepot;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

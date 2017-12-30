package com.thesis.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Rel_It")
public class RelIt {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rel_id")
    private ItemRelease itemRelease;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemRelease getItemRelease() {
        return itemRelease;
    }

    public void setItemRelease(ItemRelease itemRelease) {
        this.itemRelease = itemRelease;
    }
    @JsonIgnore
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

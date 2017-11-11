package com.thesis.project.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Warehouse")
public class Warehouse {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "firm_id", nullable = false)
    Firm firm;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "WAR_IT",
    joinColumns = @JoinColumn(name = "War_Id", nullable = false),
    inverseJoinColumns = @JoinColumn(name ="It_Id", nullable = false))
    private Set<Item> item = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItem() {
        return item;
    }

    public void setItem(Set<Item> item) {
        this.item = item;
    }
}

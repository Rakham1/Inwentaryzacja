package com.thesis.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = ".Group")
public class Group {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    private String name;
    private Boolean isPermanent;

    @OneToMany(mappedBy = "group")
    private Set<Item> item = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(Boolean permanent) {
        isPermanent = permanent;
    }

    public Set<Item> getItem() {
        return item;
    }
    @JsonIgnore
    public void setItem(Set<Item> item) {
        this.item = item;
    }
}

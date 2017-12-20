package com.thesis.project.model;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class InHistory {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;

    private Integer amount;

    private String details;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "IN_IT",
            joinColumns = @JoinColumn(name = "In_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "It_Id", nullable = false))
    private Set<Item> item = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Set<Item> getItem() {
        return item;
    }

    public void setItem(Set<Item> item) {
        this.item = item;
    }
}

package model;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OutHistory {

    @Id
    @GeneratedValue
    private long Id;

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;

    private int amount;

    private String details;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "OUT_IT",
            joinColumns = @JoinColumn(name = "Out_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "It_Id", nullable = false))
    private Set<Item> item = new HashSet<>();

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

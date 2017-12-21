package com.thesis.project.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ItemRelease")
public class ItemRelease {
    @Id
    @GeneratedValue
    private Long id;
    private Date releaseDate;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name="warehouse_id")
    private Warehouse warehouse;
    @OneToMany(mappedBy = "itemRelease")
    private Set<RelIt> relIts = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Set<RelIt> getRelIts() {
        return relIts;
    }

    public void setRelIts(Set<RelIt> relIts) {
        this.relIts = relIts;
    }
}

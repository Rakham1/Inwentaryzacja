package com.thesis.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String relDocName;
    private Date releaseDate;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name="warehouse_id")
    private Warehouse warehouse;
    @OneToMany(mappedBy = "itemRelease")
    private Set<RelIt> relIts = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelDocName() {
        return relDocName;
    }

    public void setRelDocName(String relDocName) {
        this.relDocName = relDocName;
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
    @JsonIgnore
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
    @JsonIgnore
    public Set<RelIt> getRelIts() {
        return relIts;
    }

    public void setRelIts(Set<RelIt> relIts) {
        this.relIts = relIts;
    }

    public Contractor getContractor() {
        return contractor;
    }
    @JsonIgnore
    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}

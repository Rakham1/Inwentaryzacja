package com.thesis.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "StorageDepot")
public class StorageDepot {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;
    private Date depotDate;
    private String invoiceName;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    private String comment;
    @OneToMany(mappedBy = "storageDepot")
    private Set<DepIt> depIt = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contractor getContractor() {
        return contractor;
    }
    @JsonIgnore
    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Date getDepotDate() {
        return depotDate;
    }

    public void setDepotDate(Date depotDate) {
        this.depotDate = depotDate;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    @JsonIgnore
    public Set<DepIt> getDepIt() {
        return depIt;
    }

    public void setDepIt(Set<DepIt> depIt) {
        this.depIt = depIt;
    }

    public Person getPerson() {
        return person;
    }
    @JsonIgnore
    public void setPerson(Person person) {
        this.person = person;
    }
}

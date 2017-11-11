package com.thesis.project.dto;

public class UserDTO {
    private long id;
    private String name;
    private String surname;
    private FirmDTO firm;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public FirmDTO getFirm() {
        return firm;
    }

    public void setFirm(FirmDTO firm) {
        this.firm = firm;
    }
}

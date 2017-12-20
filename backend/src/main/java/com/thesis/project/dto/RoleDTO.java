package com.thesis.project.dto;

public class RoleDTO {
    private Long id;
    private String name;
    private String privilages;

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

    public String getPrivilages() {
        return privilages;
    }

    public void setPrivilages(String privilages) {
        this.privilages = privilages;
    }
}
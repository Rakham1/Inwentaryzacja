package com.thesis.project.dto;

public class GroupDTO {
    private long id;
    private long name;
    private boolean isPermanent;

    public GroupDTO(long id, long name, boolean isPermanent) {
        this.id = id;
        this.name = name;
        this.isPermanent = isPermanent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(boolean permanent) {
        isPermanent = permanent;
    }
}

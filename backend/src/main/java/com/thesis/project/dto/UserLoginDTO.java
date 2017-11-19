package com.thesis.project.dto;

public class UserLoginDTO {

    private long id;
    String username;
    String password;

    public UserLoginDTO(long id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return username;
    }

    public void setNickname(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

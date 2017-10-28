package dto;


import java.util.Collection;

public class UserDTO {
    private long id;
    private String nickname;
    private String password;
    private String name;
    private String surname;
    private String mail;
    private Collection<WarehouseDTO> warehouse;
    private Collection<FirmDTO> firm;

    public UserDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Collection<FirmDTO> getFirm() {
        return firm;
    }

    public void setFirm(Collection<FirmDTO> firm) {
        this.firm = firm;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Collection<WarehouseDTO> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Collection<WarehouseDTO> warehouse) {
        this.warehouse = warehouse;
    }
}

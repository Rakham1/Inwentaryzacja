package dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class InventoryDTO {
    private long inventId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;
    private String inventUser;
    private String squad;
    private String comment;
    private UserDTO user;

    public long getInventId() {
        return inventId;
    }

    public void setInventId(long inventId) {
        this.inventId = inventId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getInventUser() {
        return inventUser;
    }

    public void setInventUser(String inventUser) {
        this.inventUser = inventUser;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}

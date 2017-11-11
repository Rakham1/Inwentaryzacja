package com.thesis.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

public class OutHistoryDTO {
    private long idOutHistory;
    private int amount;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;
    private String details;

    public long getId() {
        return idOutHistory;
    }

    public void setId(long idOutHistory) {
        this.idOutHistory = idOutHistory;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

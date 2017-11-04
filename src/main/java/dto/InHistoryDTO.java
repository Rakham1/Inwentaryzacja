package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

public class InHistoryDTO {
    private long idInHistory;
    private int amount;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;
    private String details;

    public long getId() {
        return idInHistory;
    }

    public void setId(long idInHistory) {
        this.idInHistory = idInHistory;
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

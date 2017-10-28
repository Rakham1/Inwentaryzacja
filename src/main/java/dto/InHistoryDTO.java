package dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Collection;

public class InHistoryDTO {
    private long inId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;
    private String details;
    private Collection<ItemDTO> item;
    private int amount;

    public long getInId() {
        return inId;
    }

    public void setInId(long inId) {
        this.inId = inId;
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

    public Collection<ItemDTO> getItem() {
        return item;
    }

    public void setItem(Collection<ItemDTO> item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

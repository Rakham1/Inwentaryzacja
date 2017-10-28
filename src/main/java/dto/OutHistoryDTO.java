package dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Collection;

public class OutHistoryDTO {
    private long outId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;
    private String details;
    private Collection<ItemDTO> item;
    private int amount;

    public long getOutId() {
        return outId;
    }

    public void setOutId(long outId) {
        this.outId = outId;
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

package dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Collection;

public class dateDTO {
    private long dateId;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp date;
    private Collection<ItemDTO> item;

    public long getDateId() {
        return dateId;
    }

    public void setDateId(long dateId) {
        this.dateId = dateId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Collection<ItemDTO> getItem() {
        return item;
    }

    public void setItem(Collection<ItemDTO> item) {
        this.item = item;
    }
}

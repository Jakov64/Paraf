package rs.raf.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public abstract class HistoryEntry {
    private LocalDateTime dateTime;
    private String name;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public HistoryEntry(String name){
        this.dateTime = LocalDateTime.now();
        this.name = name;
    }

    protected String getFormattedTime() {
        return "[" + dateTime.format(formatter) + "]";
    }

    @Override
    public abstract String toString();
}

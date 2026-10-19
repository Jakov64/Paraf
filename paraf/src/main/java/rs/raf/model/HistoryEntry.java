package rs.raf.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class HistoryEntry {
    private LocalDateTime dateTime;
    private String text;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public HistoryEntry(String text){
        HistoryEntry entry = new HistoryEntry(LocalDateTime.now(), text);
    }

    public HistoryEntry(LocalDateTime dateTime, String text) {
        this.dateTime = dateTime;
        this.text = text;
    }

    @Override
    public String toString() {
        return "[" + dateTime.format(formatter) + "] " + text;
    }
}

package rs.raf.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class HistoryEntry { /// Moze da bude apstraktna klasa, a da podklase samo menjaju toString metodu
    private LocalDateTime dateTime;
    private String text;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public HistoryEntry(String text){
        this.dateTime = LocalDateTime.now();
        this.text = text;
    }

    @Override
    public String toString() {
        return "[" + dateTime.format(formatter) + "] Created \"" + text + "\"";
    }
}

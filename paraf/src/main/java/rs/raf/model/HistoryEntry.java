package rs.raf.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class HistoryEntry {
    private LocalDateTime vreme;
    private String tekst;

    private static DateTimeFormatter formatiranoVreme = DateTimeFormatter.ofPattern("HH:mm:ss");

    public HistoryEntry(String tekst){
        HistoryEntry unos = new HistoryEntry(LocalDateTime.now(), tekst);
    }

    public HistoryEntry(LocalDateTime vreme, String tekst) {
        this.vreme = vreme;
        this.tekst = tekst;
    }
}

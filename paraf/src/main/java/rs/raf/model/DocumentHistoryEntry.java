package rs.raf.model;

public class DocumentHistoryEntry extends HistoryEntry{
    public DocumentHistoryEntry(String text) {
        super(text);
    }

    @Override
    public String toString() {
        return getFormattedTime() + " Created \"" + getName() + "\"";
    }
}

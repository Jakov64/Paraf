package rs.raf.model;

public class FolderHistoryEntry extends HistoryEntry{
    public FolderHistoryEntry(String text) {
        super(text);
    }

    @Override
    public String toString() {
        return getFormattedTime() + " Created folder \"" + getName() + "\"";
    }
}

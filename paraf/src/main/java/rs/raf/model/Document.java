package rs.raf.model;

public abstract class Document {
    private String name;
    private String content;

    public Document(String name, String content) {
        this.name = name;
        this.content = "";
    }

    public abstract boolean lineWrap(); //da li se tekst prelama
    public abstract boolean monospace(); //fiksna sirina - vazi za CodeDocument
}

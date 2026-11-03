package rs.raf.model.tree;

public abstract class Document extends NodeComponent {
    private String content;

    public Document(String name, NodeComponent parent) {
        super(name, parent);
        this.content = "";
    }

    public abstract boolean lineWrap(); //da li se tekst prelama
    public abstract boolean monospace(); //fiksna sirina - vazi za CodeDocument
}

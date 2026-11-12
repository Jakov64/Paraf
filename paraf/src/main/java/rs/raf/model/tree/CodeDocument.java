package rs.raf.model.tree;

import lombok.Getter;
import lombok.Setter;

public class CodeDocument extends Document {

    @Getter
    private static int counter = 0;

    public static String nextName(){
        counter += 1;
        return "Code" + counter;
    }

    public CodeDocument(String name, NodeComponent parent) {
        super(name, parent);
    }

    @Override
    public Document duplicate() {
        Document document  = new PlainDocument(this.getName(), this.getParent());
        return document;
    }

    @Override
    public boolean lineWrap() {
        return false;
    }

    @Override
    public boolean monospace() {
        return true;
    }
}

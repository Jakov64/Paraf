package rs.raf.model.tree;

import lombok.Getter;
import lombok.Setter;

public class PlainDocument extends Document {

    @Getter
    private static int counter = 0;

    public static String nextName(){
        counter += 1;
        return "Document" + counter;
    }

    public PlainDocument(String name, NodeComponent parent) {
        super(name, parent);
    }

    @Override
    public boolean lineWrap() {
        return true;
    }

    @Override
    public boolean monospace() {
        return false;
    }
}

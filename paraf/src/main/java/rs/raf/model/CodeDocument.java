package rs.raf.model;

import lombok.Getter;
import lombok.Setter;

public class CodeDocument extends Document{

    @Getter
    @Setter

    private static int counter = 0;

    public static String nextName(){
        counter += 1;
        return "Code" + counter;
    }

    public CodeDocument(String name) {
        super(name);
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

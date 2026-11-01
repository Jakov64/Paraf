package rs.raf.model.tree;

import lombok.Getter;
import lombok.Setter;

public class PlainDocument extends Document {

    @Getter
    @Setter
    private static int counter = 0;

    public static String nextName(){
        counter += 1;
        return "Document" + counter;
    }
    //kada budemo pravili Action (controller klasu) ovo cemo da koristimo otp ovako
    //Document document = new PlainDocument(PlainDocument.nextDefaultName()); wohoo


    @Override
    public String writeHistory() {
        return "";
    }

    public PlainDocument(String name) {
        super(name);
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

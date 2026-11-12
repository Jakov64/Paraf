package rs.raf.model.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Folder extends NodeComponent {

    private List<NodeComponent> children;
    private static int counter = 0;

    public Folder(String name){
        super(name);
        children = new ArrayList<>();
    }

    public void addChild(NodeComponent nodeComponent){
        children.add(nodeComponent);
        nodeComponent.setParent(this);
    }

    public static String nextName() {
        counter += 1;
        return "Folder" + counter;
    }

    public int getDocumentCount(){
        int i = 0;
        for(NodeComponent nc : children){
            if(nc instanceof Folder){
                i += ((Folder) nc).getDocumentCount();
            }
            else{
                i++;
            }
        }
        return i;
    }
}

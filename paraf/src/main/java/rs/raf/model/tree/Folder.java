package rs.raf.model.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class Folder extends NodeComponent {
    @Getter
    @Setter

    private List<NodeComponent> children;

    public Folder(String name){
        super(name);
        children = new ArrayList<>();
    }

    public void addChild(NodeComponent nodeComponent){
        children.add(nodeComponent);
        nodeComponent.setParent(this);
    }
}

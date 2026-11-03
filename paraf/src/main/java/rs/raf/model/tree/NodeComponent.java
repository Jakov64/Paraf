package rs.raf.model.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class NodeComponent {
    private String name;
    private NodeComponent parent;

    public NodeComponent(String name){
        this.name = name;
        parent = null;
    }

    public NodeComponent(String name, NodeComponent parent){
        this.name = name;
        this.parent = parent;
    }
}

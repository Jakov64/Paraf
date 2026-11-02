package rs.raf.model.tree;

import lombok.Getter;

@Getter
abstract class NodeComponent {
    private String name;

    public NodeComponent(String name){
        this.name = name;
    }
}

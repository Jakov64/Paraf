package rs.raf.model.tree;

import java.util.ArrayList;
import java.util.List;

public class Folder implements NodeComponent{
    private List<NodeComponent> Children = new ArrayList<>();

    @Override
    public String writeHistory() {
        return "";
    }
}

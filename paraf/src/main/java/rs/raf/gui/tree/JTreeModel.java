package rs.raf.gui.tree;

import lombok.Getter;
import lombok.Setter;
import rs.raf.model.tree.Folder;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class JTreeModel implements TreeModel {

    @Getter
    @Setter
    private Folder root;
    private List<TreeModelListener> listeners = new ArrayList<>();
    public JTreeModel(Folder root) {
        this.root = root;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        if(parent instanceof Folder){
            Folder folder = (Folder) parent;
            return folder.getChildren().get(index);
        }
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
        if(parent instanceof Folder){
            Folder folder = (Folder) parent;
            return folder.getChildren().size();
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        return !(node instanceof Folder);
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        //necemo da stavimo da sami mogu da menjaju
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if(parent instanceof Folder){ //mozda dodati && child instanceof NodeComponent da ne bi doslo do greske ako neko prosledi nesto random?
            Folder folder = (Folder) parent;
            folder.getChildren().indexOf(child);
        }
        return 0;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listeners.remove(l);
    }

    public void reload() {
        TreeModelEvent event = new TreeModelEvent(this, new Object[]{root});
        for (TreeModelListener listener : listeners) {
            listener.treeStructureChanged(event);
        }
    }
}

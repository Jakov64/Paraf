package rs.raf.gui.tree;

import lombok.Getter;
import lombok.Setter;
import rs.raf.core.ApplicationFramework;
import rs.raf.model.tree.Folder;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class JTreeModel implements TreeModel {

    private List<TreeModelListener> listeners = new ArrayList<>();
    public JTreeModel() {
    }

    @Override
    public Object getRoot() {
        return ApplicationFramework.getInstance().getProject();
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
            return folder.getChildren().indexOf(child);
        }
        return -1; //cvor ne pripada roditelju
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
        TreeModelEvent event = new TreeModelEvent(this, new Object[]{ApplicationFramework.getInstance().getProject()});
        for (TreeModelListener listener : listeners) {
            listener.treeStructureChanged(event);
        }
    }
}

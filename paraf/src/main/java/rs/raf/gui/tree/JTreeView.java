package rs.raf.gui.tree;

import lombok.Getter;
import lombok.Setter;
import rs.raf.core.ApplicationFramework;
import rs.raf.model.tree.NodeComponent;

import javax.swing.*;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

@Getter
@Setter
public class JTreeView extends JPanel {
    private JTree jTree;
    private JTreeModel jTreeModel;

    public JTreeView(LayoutManager layout) {
        super(new BorderLayout());
        this.jTreeModel = new JTreeModel();
        this.jTree = new JTree(jTreeModel);
        this.jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        add(new JScrollPane(jTree),BorderLayout.CENTER);
    }

    public NodeComponent getSelectedNode() {
        TreePath path = jTree.getSelectionPath();
        if (path != null && path.getLastPathComponent() instanceof NodeComponent) {
            return (NodeComponent) path.getLastPathComponent();
        }
        return null;
    }
}

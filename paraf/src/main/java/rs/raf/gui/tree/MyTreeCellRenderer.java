package rs.raf.gui.tree;

import rs.raf.model.tree.Folder;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class MyTreeCellRenderer extends DefaultTreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        if (value instanceof Folder) {
            Folder folder = (Folder) value;

            setText(folder.getName() + " (" +
                    folder.getDocumentCount() + ")");
        }

        return this;
    }
}

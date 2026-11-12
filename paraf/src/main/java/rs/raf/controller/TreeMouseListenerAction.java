package rs.raf.controller;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gui.swing.MainFrame;
import rs.raf.model.tree.Document;
import rs.raf.model.tree.Folder;

import javax.swing.JTree;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Getter
@Setter
public class TreeMouseListenerAction extends MouseAdapter {

    private final JTree jTree;

    public TreeMouseListenerAction(JTree jTree) {
        this.jTree = jTree;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        TreePath path = jTree.getPathForLocation(e.getX(), e.getY());
        if (e.getClickCount() == 2) {

            if (path != null && path.getLastPathComponent() instanceof Document) {
                Document doc = (Document) path.getLastPathComponent();
                MainFrame.getInstance().getDocumentTabManager().openOrSelect(doc);
            }
        }
    }
}
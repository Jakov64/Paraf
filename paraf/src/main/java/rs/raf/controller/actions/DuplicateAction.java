package rs.raf.controller.actions;

import rs.raf.core.ApplicationFramework;
import rs.raf.gui.swing.MainFrame;
import rs.raf.model.DocumentHistoryEntry;
import rs.raf.model.tree.Document;
import rs.raf.model.tree.Folder;
import rs.raf.model.tree.NodeComponent;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;

public class DuplicateAction extends ParafAbstractAction{
    public DuplicateAction() {
        super("Duplicate");
    }

    @Override
    protected void perform(ActionEvent event) {
        NodeComponent selected = MainFrame.getInstance().getTreeView().getSelectedNode();
        Document duplicatedDocument;
        if(selected instanceof Document){
            duplicatedDocument = (((Document) selected).duplicate());

            Folder originalFolder = (Folder) selected.getParent();

            originalFolder.addChild(duplicatedDocument);

            MainFrame.getInstance().getDocumentTabManager().openOrSelect(duplicatedDocument);
            ApplicationFramework.getInstance().getDocumentModel().addDocument(duplicatedDocument);

            MainFrame.getInstance().getTreeView().getJTreeModel().reload();

            ApplicationFramework.getInstance().getHistory().addEntry(new DocumentHistoryEntry(duplicatedDocument.getName()));
        }

    }
}

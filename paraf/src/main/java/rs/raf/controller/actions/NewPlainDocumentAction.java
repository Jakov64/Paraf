package rs.raf.controller.actions;

import rs.raf.controller.DocumentTabController;
import rs.raf.core.ApplicationFramework;
import rs.raf.gui.swing.MainFrame;
import rs.raf.model.tree.Document;
import rs.raf.model.tree.Folder;
import rs.raf.model.tree.NodeComponent;
import rs.raf.model.tree.PlainDocument;

import java.awt.event.ActionEvent;

public class NewPlainDocumentAction extends ParafAbstractAction {

    public NewPlainDocumentAction() {
        super("New Plain Document");
    }

    @Override
    protected void perform(ActionEvent event) {
        Document document = new PlainDocument(PlainDocument.nextName(), null);

        NodeComponent selected = MainFrame.getInstance().getTreeView().getSelectedNode();
        Folder targetFolder;

        if (selected instanceof Folder) {
            targetFolder = (Folder) selected;
        } else if (selected instanceof Document) {
            targetFolder = (Folder) selected.getParent();
        } else {
            targetFolder = ApplicationFramework.getInstance().getProject();
        }

        if (targetFolder == null) {
            targetFolder = ApplicationFramework.getInstance().getProject();
        }
        targetFolder.addChild(document);

        MainFrame.getInstance().getTreeView().getJTreeModel().reload();
        MainFrame.getInstance().getDocumentTabManager().openOrSelect(document);
        ApplicationFramework.getInstance().getHistory().addEntry( document.getName());
    }
}
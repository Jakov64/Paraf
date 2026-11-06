package rs.raf.controller.actions;

import rs.raf.core.ApplicationFramework;
import rs.raf.gui.swing.MainFrame;
import rs.raf.model.DocumentHistoryEntry;
import rs.raf.model.tree.CodeDocument;
import rs.raf.model.tree.Document;
import rs.raf.model.tree.Folder;
import rs.raf.model.tree.NodeComponent;

import java.awt.event.ActionEvent;

public class NewCodeDocumentAction extends ParafAbstractAction {

    public NewCodeDocumentAction() {
        super("New code document");
    }

    @Override
    protected void perform(ActionEvent event) {
        Document document = new CodeDocument(CodeDocument.nextName(), null);
        NodeComponent selected = MainFrame.getInstance().getTreeView().getSelectedNode();
        Folder targetFolder;
        if (selected instanceof Folder) {
            targetFolder = (Folder) selected;
        } else if (selected instanceof Document && selected.getParent() instanceof Folder) {
            targetFolder = (Folder) selected.getParent();
        } else {
            targetFolder = ApplicationFramework.getInstance().getProject();
        }
        targetFolder.addChild(document);

        MainFrame.getInstance().getTreeView().getJTreeModel().reload();
        MainFrame.getInstance().getDocumentTabManager().openOrSelect(document);

        ApplicationFramework.getInstance().getHistory().addEntry(new DocumentHistoryEntry(document.getName()));
    }
}
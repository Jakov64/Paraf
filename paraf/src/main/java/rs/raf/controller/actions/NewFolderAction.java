package rs.raf.controller.actions;

import rs.raf.core.ApplicationFramework;
import rs.raf.gui.swing.MainFrame;
import rs.raf.model.FolderHistoryEntry;
import rs.raf.model.tree.Document;
import rs.raf.model.tree.Folder;
import rs.raf.model.tree.NodeComponent;

import java.awt.event.ActionEvent;

public class NewFolderAction extends ParafAbstractAction {

    public NewFolderAction() {
        super("New Folder");
    }

    @Override
    protected void perform(ActionEvent event) {
        Folder folder = new Folder(Folder.nextName());
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

        targetFolder.addChild(folder);
        MainFrame.getInstance().getTreeView().getJTreeModel().reload();
        ApplicationFramework.getInstance().getHistory().addEntry(new FolderHistoryEntry(folder.getName()));
    }
}
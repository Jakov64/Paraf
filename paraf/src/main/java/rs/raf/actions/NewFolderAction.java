package rs.raf.actions;

import rs.raf.core.ApplicationFramework;
import rs.raf.model.HistoryEntry;
import rs.raf.model.tree.CodeDocument;
import rs.raf.model.tree.Folder;

import java.awt.event.ActionEvent;

public class NewFolderAction extends ParafAbstractAction{
    public NewFolderAction() {
        super("New Folder");
    }

    @Override
    protected void perform(ActionEvent event) {

        Folder folder = new Folder(CodeDocument.nextName());
        ApplicationFramework.getInstance().getHistory().addEntry(folder.getName());
        //System.out.println("Izvrseno"); Izvsrsava se => treba lepo da povezem History i History panel i da proverim da li slanje HistoryEntry
        //objekta narusava mvc


        // Ovde bi išao poziv za otvaranje dokumenta u editoru,
        // kada MainFrame bude imao takvu metodu.
    }
}

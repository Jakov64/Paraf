package rs.raf.controller.actions;

import rs.raf.controller.DocumentTabController;
import rs.raf.core.ApplicationFramework;
import rs.raf.gui.swing.MainFrame;
import rs.raf.gui.tab.DocumentTabPanel;
import rs.raf.model.DocumentModel;
import rs.raf.model.tree.Document;
import rs.raf.model.tree.PlainDocument;

import java.awt.event.ActionEvent;

public class NewPlainDocumentAction extends ParafAbstractAction{
    public NewPlainDocumentAction() {
        super("New Plain Document");
    }

    @Override
    protected void perform(ActionEvent event) {

        Document document = new PlainDocument(PlainDocument.nextName(), null);
        //Ovo sve mozda moze da se resi preko nekog factorya
        ApplicationFramework.getInstance().getHistory().addEntry(document.getName());
        MainFrame.getInstance().getDocumentTabManager().openOrSelect(document);
        DocumentTabController documentTabController = new DocumentTabController(document,
                MainFrame.getInstance().getDocumentTabManager().getDocumentTabPanel(document));

        ApplicationFramework.getInstance().getDocumentModel().addDocument(document);


        // Ovde bi išao poziv za otvaranje dokumenta u editoru,
        // kada MainFrame bude imao takvu metodu.
    }
}

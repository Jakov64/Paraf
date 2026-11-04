package rs.raf.controller.actions;

import rs.raf.core.ApplicationFramework;
import rs.raf.gui.swing.MainFrame;
import rs.raf.gui.tab.DocumentTabPanel;
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
        ApplicationFramework.getInstance().getHistory().addEntry(document.getName());
        MainFrame.getInstance().getDocumentTabManager().openOrSelect(document);

        // Ovde bi išao poziv za otvaranje dokumenta u editoru,
        // kada MainFrame bude imao takvu metodu.
    }
}

package rs.raf.actions;

import rs.raf.core.ApplicationFramework;
import rs.raf.model.History;
import rs.raf.model.tree.CodeDocument;
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


        // Ovde bi išao poziv za otvaranje dokumenta u editoru,
        // kada MainFrame bude imao takvu metodu.
    }
}

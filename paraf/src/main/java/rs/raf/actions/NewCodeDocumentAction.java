package rs.raf.actions;

import rs.raf.core.ApplicationFramework;
import rs.raf.gui.swing.MainFrame;
import rs.raf.model.tree.CodeDocument;
import rs.raf.model.tree.Document;

import java.awt.event.ActionEvent;

public class NewCodeDocumentAction extends ParafAbstractAction{
    public NewCodeDocumentAction() {
        super("New code document");
    }

    @Override
    protected void perform(ActionEvent event) {

        Document document = new CodeDocument(CodeDocument.nextName(), null);
        ApplicationFramework.getInstance().getHistory().addEntry(document.getName());

        // Ovde bi išao poziv za otvaranje dokumenta u editoru,
        // kada MainFrame bude imao takvu metodu.
    }




    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }




}

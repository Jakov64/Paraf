package rs.raf.actions;

import rs.raf.model.tree.CodeDocument;

import java.awt.event.ActionEvent;

public class ExitAction extends ParafAbstractAction{
    public ExitAction() {
        super("Exit");
    }

    @Override
    protected void perform(ActionEvent event) {

        //CodeDocument document = new CodeDocument(CodeDocument.nextName(), null); treba Exit logika


        // Ovde bi išao poziv za otvaranje dokumenta u editoru,
        // kada MainFrame bude imao takvu metodu.
    }
}

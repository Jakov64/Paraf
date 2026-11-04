package rs.raf.controller.actions;

import rs.raf.gui.swing.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class ExitAction extends ParafAbstractAction{
    public ExitAction() {
        super("Exit");
    }

    @Override
    protected void perform(ActionEvent event) {

        MainFrame.getInstance().dispatchEvent(new WindowEvent(MainFrame.getInstance(),WindowEvent.WINDOW_CLOSING));
        //CodeDocument document = new CodeDocument(CodeDocument.nextName(), null); treba Exit logika


        // Ovde bi išao poziv za otvaranje dokumenta u editoru,
        // kada MainFrame bude imao takvu metodu.
    }
}

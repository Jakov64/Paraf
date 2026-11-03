package rs.raf.actions;

import rs.raf.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class NewCodeDocumentAction extends ParafAbstractAction{
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().setTitle("Uradjeno");
    }

    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }




}

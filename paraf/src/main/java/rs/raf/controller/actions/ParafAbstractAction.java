package rs.raf.controller.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class ParafAbstractAction extends AbstractAction{

    protected ParafAbstractAction(String name) {
        super(name); // postavlja tekst akcije u meniju i toolbaru
    }

    @Override
    public final void actionPerformed(ActionEvent event) {
        perform(event);
    }

    protected abstract void perform(ActionEvent event);
}

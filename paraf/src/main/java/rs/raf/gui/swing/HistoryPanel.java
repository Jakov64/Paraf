package rs.raf.gui.swing;

import rs.raf.model.History;
import rs.raf.model.HistoryEntry;
import rs.raf.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class HistoryPanel extends JPanel implements ISubscriber {

    DefaultListModel<String> model = new DefaultListModel<>();

    public HistoryPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 0));
        add(new JScrollPane(new JList<>(model)), BorderLayout.CENTER);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof HistoryEntry){
            HistoryEntry entry = (HistoryEntry) notification;
            model.addElement(entry.getText());
        }
    }
}

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
        setPreferredSize(new Dimension(250, 0));

        JList<String> historyList = new JList<>(model);

        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        historyList.setCellRenderer(renderer);

        add(new JScrollPane(historyList), BorderLayout.CENTER);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof HistoryEntry){
            HistoryEntry entry = (HistoryEntry) notification;
            model.addElement(entry.toString());
        }
    }
}

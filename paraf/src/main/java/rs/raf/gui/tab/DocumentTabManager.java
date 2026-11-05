package rs.raf.gui.tab;

import rs.raf.model.tree.Document;

import javax.swing.*;
import java.awt.*;
import java.util.IdentityHashMap;
import java.util.Map;

public class DocumentTabManager {
    private final JTabbedPane tabbedPane;
    private final Map<Document, DocumentTabPanel> openTabs = new IdentityHashMap<>();

    public DocumentTabManager(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public void openOrSelect(Document document) {
        DocumentTabPanel panel = openTabs.get(document);

        if (panel == null) {
            panel = new DocumentTabPanel(document);
            openTabs.put(document, panel);
            tabbedPane.addTab(document.getName(), panel);

            tabbedPane.addTab(document.getName(), panel);
            openTabs.put(document, panel);

            int index = tabbedPane.indexOfComponent(panel);
            tabbedPane.setTabComponentAt(index, createTabHeader(document, panel));
        }

        tabbedPane.setSelectedComponent(panel);
    }

    public DocumentTabPanel getDocumentTabPanel(Document document){
        return openTabs.get(document);
    }

    private Component createTabHeader(Document document, DocumentTabPanel panel) {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        header.setOpaque(false);

        JLabel title = new JLabel(document.getName());

        JButton closeButton = new JButton("×");
        closeButton.setToolTipText("Zatvori tab");
        closeButton.setFocusable(false);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setMargin(new Insets(0, 4, 0, 4));

        closeButton.addActionListener(event -> closeTab(document));

        header.add(title);
        header.add(closeButton);

        return header;
    }

    private void closeTab(Document document) {
        DocumentTabPanel panel = openTabs.remove(document);

        if (panel != null) {
            tabbedPane.remove(panel);
        }
    }
}

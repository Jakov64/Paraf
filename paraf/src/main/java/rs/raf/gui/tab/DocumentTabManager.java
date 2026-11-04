package rs.raf.gui.tab;

import rs.raf.model.tree.Document;

import javax.swing.*;
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
        }

        tabbedPane.setSelectedComponent(panel);
    }
}

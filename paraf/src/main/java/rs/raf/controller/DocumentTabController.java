package rs.raf.controller;

import rs.raf.gui.tab.DocumentTabPanel;
import rs.raf.model.tree.Document;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DocumentTabController implements DocumentListener {
    private final Document document;
    private final DocumentTabPanel panel;

    public DocumentTabController(Document document, DocumentTabPanel panel) {
        this.document = document;
        this.panel = panel;

        panel.getTextArea()
                .getDocument()
                .addDocumentListener(this);
    }

    @Override
    public void insertUpdate(DocumentEvent event) {
        saveTextToModel();
    }

    @Override
    public void removeUpdate(DocumentEvent event) {
        saveTextToModel();
    }

    @Override
    public void changedUpdate(DocumentEvent event) {
        saveTextToModel();
    }

    private void saveTextToModel() {
        document.setContent(panel.getTextArea().getText());
    }
}

package rs.raf.gui.tab;

import rs.raf.model.tree.Document;

import javax.swing.*;
import java.awt.*;

public class DocumentTabPanel extends JPanel{
    public DocumentTabPanel(Document document) {
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(document.getContent());
        textArea.setLineWrap(document.lineWrap());
        if(document.monospace()){
            textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        }

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

}

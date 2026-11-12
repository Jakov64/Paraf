package rs.raf.core;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gui.swing.MainFrame;
import rs.raf.model.DocumentModel;
import rs.raf.model.History;
import rs.raf.model.tree.Folder;

@Getter
@Setter
public class ApplicationFramework {

    private static ApplicationFramework instance;

    private Folder project;
    private History history;
    private DocumentModel documentModel;

    private ApplicationFramework() {
        this.project = new Folder("Project");
        this.history = new History();
        this.documentModel = new DocumentModel();
    }

    public static ApplicationFramework getInstance() {
        if (instance == null) {
            instance = new ApplicationFramework();
        }
        return instance;
    }

    public void initialize() {
        MainFrame.getInstance().setVisible(true);
        documentModel.addSubscriber(MainFrame.getInstance());
    }
}
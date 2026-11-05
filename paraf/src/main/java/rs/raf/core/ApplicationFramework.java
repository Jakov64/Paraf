package rs.raf.core;


import lombok.Getter;
import lombok.Setter;
import rs.raf.gui.swing.MainFrame;
import rs.raf.gui.tree.JTreeModel;
import rs.raf.model.DocumentModel;
import rs.raf.model.History;
import rs.raf.model.tree.Document;

@Getter
@Setter
public class ApplicationFramework {
    @Setter
    private JTreeModel project;

    private final History history;

    private final DocumentModel documentModel;

    public ApplicationFramework() {
        //project = new JTreeModel();
        history = new History();
        documentModel = new DocumentModel();
    }

    private static ApplicationFramework instance;

    public void initialize() {
        MainFrame.getInstance().setVisible(true);
    }

    public static ApplicationFramework getInstance(){
        if(instance == null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}

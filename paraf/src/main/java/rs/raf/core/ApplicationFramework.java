package rs.raf.core;


import lombok.Getter;
import lombok.Setter;
import rs.raf.gui.swing.MainFrame;
import rs.raf.gui.tree.JTreeModel;
import rs.raf.model.tree.Folder;
import rs.raf.model.History;

public class ApplicationFramework {
    @Getter
    @Setter
    private JTreeModel project;

    @Getter
    private final History history;

    public ApplicationFramework() {
        project = new JTreeModel();
        history = new History();
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

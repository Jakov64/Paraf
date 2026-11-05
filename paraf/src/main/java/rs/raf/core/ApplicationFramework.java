package rs.raf.core;


import lombok.Getter;
import lombok.Setter;
import rs.raf.gui.swing.MainFrame;
import rs.raf.gui.tree.JTreeModel;
import rs.raf.model.History;
import rs.raf.model.tree.Folder;

@Getter
@Setter
public class ApplicationFramework {

    private Folder project;
    private final History history;

    private ApplicationFramework() {
        project = new Folder("Project");
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

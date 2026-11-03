package rs.raf.core;


import lombok.Getter;
import lombok.Setter;
import rs.raf.gui.swing.MainFrame;
import rs.raf.gui.tree.JTreeModel;
import rs.raf.model.tree.Folder;

public class ApplicationFramework {
    @Getter
    @Setter
    private JTreeModel project;
    public ApplicationFramework() {
        project = new JTreeModel();
    }

    private static ApplicationFramework instance;

    public void initialize() {
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }

    public static ApplicationFramework getInstance(){
        if(instance == null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}

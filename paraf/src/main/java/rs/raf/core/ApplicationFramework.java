package rs.raf.core;


import rs.raf.gui.swing.MainFrame;
import rs.raf.model.tree.Folder;

public class ApplicationFramework {

    private Folder project;

    public ApplicationFramework() {
        project = new Folder("Project");
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

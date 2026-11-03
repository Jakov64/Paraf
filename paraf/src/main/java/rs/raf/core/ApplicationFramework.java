package rs.raf.core;


import rs.raf.gui.swing.MainFrame;

public class ApplicationFramework {

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

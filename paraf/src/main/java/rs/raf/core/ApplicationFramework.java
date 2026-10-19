package rs.raf.core;


import rs.raf.gui.swing.MainFrame;

public class ApplicationFramework {

    public void initialize() {
        //singleton?
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}

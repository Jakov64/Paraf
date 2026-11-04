package rs.raf.core;


import com.sun.tools.javac.Main;
import lombok.Getter;
import lombok.Setter;
import rs.raf.gui.swing.MainFrame;
import rs.raf.model.History;

@Getter
public class ApplicationFramework {

    private static ApplicationFramework instance;

    private final History history;

    public void initialize() {
        MainFrame.getInstance().setVisible(true);
    }

    private ApplicationFramework(){
        history = new History();
    }

    public static ApplicationFramework getInstance(){
        if(instance == null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}

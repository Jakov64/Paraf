package rs.raf.gui.swing;

import lombok.Getter;
import lombok.Setter;
import rs.raf.core.ApplicationFramework;
import rs.raf.model.tree.Folder;
import rs.raf.controller.actions.ActionManager;
import rs.raf.model.History;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    @Getter
    @Setter
    public static final String TITLE = "Paraf";

    private static final String FILE_MENU_TITLE = "File";
    private static final String EXIT_ITEM_TITLE = "Exit";
    private static final int TEXT_MARGIN = 8;
    private static final int FONT_SIZE = 14;

    private static HistoryPanel historyPanel;

    //private final JTextArea textArea;

    private static MainFrame instance;

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;
    }

    private MainFrame() {
        setTitle(TITLE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width / 2, screenSize.height / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(createMenuBar());

        setJMenuBar(createMenuBar());
        add(createCenteredToolBar(), BorderLayout.NORTH);
        add( new JTree(), BorderLayout.WEST);

        historyPanel = new HistoryPanel();
        ApplicationFramework.getInstance().getHistory().addSubscriber(historyPanel);
        add(historyPanel, BorderLayout.EAST);

        add(new JTabbedPane(), BorderLayout.CENTER);
    }

    private JPanel createCenteredToolBar() {
        ActionManager actions = ActionManager.getInstance();

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        toolBar.add(actions.getNewFolderAction());
        toolBar.add(actions.getNewPlainDocumentAction());
        toolBar.add(actions.getNewCodeDocumentAction());
        toolBar.addSeparator();
        toolBar.add(actions.getExitAction());

        JPanel toolbarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        toolbarPanel.add(toolBar);

        return toolbarPanel;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        fileMenu.add(new JMenuItem(ActionManager.getInstance().getNewFolderAction()));
        fileMenu.add(new JMenuItem(ActionManager.getInstance().getNewPlainDocumentAction()));
        fileMenu.add(new JMenuItem(ActionManager.getInstance().getNewCodeDocumentAction()));
        fileMenu.addSeparator();
        fileMenu.add(new JMenuItem(ActionManager.getInstance().getExitAction()));

        menuBar.add(fileMenu);
        return menuBar;
    }
}

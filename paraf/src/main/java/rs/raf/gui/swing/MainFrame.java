package rs.raf.gui.swing;

import lombok.Getter;
import lombok.Setter;
import rs.raf.core.ApplicationFramework;
import rs.raf.controller.actions.ActionManager;
import rs.raf.gui.tab.DocumentTabManager;
import rs.raf.gui.tree.JTreeView;
import rs.raf.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

public class MainFrame extends JFrame implements ISubscriber {


    public static final String TITLE = "Paraf";

    private static final String FILE_MENU_TITLE = "File";
    private static final String EXIT_ITEM_TITLE = "Exit";
    private static final int TEXT_MARGIN = 8;
    private static final int FONT_SIZE = 14;

    private final HistoryPanel historyPanel;
    private final JTabbedPane tabbedPane;
    private final DocumentTabManager documentTabManager;
    private final JTreeView treeView;
    private final JTextField documentCountInFolder;

    //private final JTextArea textArea;

    private static MainFrame instance;

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;
    }

    private MainFrame() {
        this.treeView = new JTreeView(new BorderLayout());
        setTitle(TITLE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width / 2, screenSize.height / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(createMenuBar());

        documentCountInFolder = new JTextField();
        add(createCenteredToolBar(), BorderLayout.NORTH);
        add( treeView, BorderLayout.WEST);

        historyPanel = new HistoryPanel();
        ApplicationFramework.getInstance().getHistory().addSubscriber(historyPanel);
        add(historyPanel, BorderLayout.EAST);

        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
        documentTabManager = new DocumentTabManager(tabbedPane);
    }

    private JPanel createCenteredToolBar() {

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        toolBar.add(ActionManager.getInstance().getNewFolderAction());
        toolBar.add(ActionManager.getInstance().getNewPlainDocumentAction());
        toolBar.add(ActionManager.getInstance().getNewCodeDocumentAction());
        toolBar.addSeparator();
        toolBar.add(ActionManager.getInstance().getExitAction());

        documentCountInFolder.setText("nista za sad");

        toolBar.add(documentCountInFolder);

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

    @Override
    public void update(Object notification) {
        if(notification instanceof Integer){
            this.setTitle(TITLE + " document count: " + notification);
        }
    }
}

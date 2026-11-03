package rs.raf.actions;

import lombok.Getter;

@Getter
public class ActionManager {
    private static ActionManager instance;

    private NewCodeDocumentAction newCodeDocumentAction;
    private ExitAction exitAction;
    private NewPlainDocumentAction newPlainDocumentAction;
    private NewFolderAction newFolderAction;

    private ActionManager(){
        newCodeDocumentAction = new NewCodeDocumentAction();
        exitAction = new ExitAction();
        newPlainDocumentAction = new NewPlainDocumentAction();
        newFolderAction = new NewFolderAction();
    }

    public static ActionManager getInstance() {
        if(instance != null){
            return instance;
        }
        instance = new ActionManager();
        return instance;
    }
}

package rs.raf.model;

import lombok.Getter;
import lombok.Setter;
import rs.raf.model.tree.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DocumentModel {
    List<Document> documents;

    public DocumentModel() {
        documents = new ArrayList<Document>();
    }

    public void addDocument(Document document){
        documents.add(document);
    }
}

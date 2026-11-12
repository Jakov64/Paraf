package rs.raf.model;

import lombok.Getter;
import lombok.Setter;
import rs.raf.model.tree.Document;
import rs.raf.observer.IPublisher;
import rs.raf.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DocumentModel implements IPublisher {
    List<Document> documents;
    Integer documentCount;
    List<ISubscriber> subscribers = new ArrayList<>();

    public DocumentModel() {
        documents = new ArrayList<Document>();
        documentCount = 0;
    }

    public void addDocument(Document document){
        documents.add(document);
        documentCount++;
        notifySubscribers(documentCount);
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for(ISubscriber sub : subscribers){
            sub.update(documentCount);
        }
    }
}

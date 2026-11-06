package rs.raf.model;

import lombok.Getter;
import lombok.Setter;
import rs.raf.observer.IPublisher;
import rs.raf.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class History implements IPublisher {

    private List<HistoryEntry> entries;
    private List<ISubscriber> subscribers;

    public History() {
        this.entries = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void addEntry(HistoryEntry histоryEntry){
        if (histоryEntry != null) {
            this.entries.add(histоryEntry);
            notifySubscribers(histоryEntry);
        }
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(!subscribers.contains(sub) && sub != null){
            subscribers.add(sub);
        }
    }

    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }
}

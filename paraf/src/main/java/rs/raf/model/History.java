package rs.raf.model;

import lombok.Getter;
import lombok.Setter;
import rs.raf.observer.IPublisher;
import rs.raf.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class History implements IPublisher {

    @Getter
    @Setter

    private List<HistoryEntry> entries = new ArrayList<>();
    private List<ISubscriber> subscribers = new ArrayList<>();

    public void addEntry(String text){
        HistoryEntry entry = new HistoryEntry(text);
        this.entries.add(entry);
        notifySubscribers(entry);
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(!subscribers.contains(sub) && sub != null){
            subscribers.add(sub);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(subscribers.contains(sub)){
            subscribers.remove(sub);
        }
    }

    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }
}

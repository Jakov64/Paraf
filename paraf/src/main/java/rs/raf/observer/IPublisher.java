package rs.raf.observer;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void notifySubscribers(Object notification);
}

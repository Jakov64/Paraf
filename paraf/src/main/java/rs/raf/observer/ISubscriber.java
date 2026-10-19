package rs.raf.observer;

//za History deo - svaki novi unos u prikazu treba da se pojavljuje automatski -> observer arhitektura
public interface ISubscriber {
    void update(Object notification);
}

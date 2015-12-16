package domain.verkoop;
/**
 * 
 * @author Larry & Annelore
 *
 */
public interface Subject {
    void addObserver(VerkoopObserver observer);

    void removeObserver(VerkoopObserver observer);

    void notifyObservers();
}
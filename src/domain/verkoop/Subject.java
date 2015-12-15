package domain.verkoop;

public interface Subject {
    void addObserver(VerkoopObserver observer);

    void removeObserver(VerkoopObserver observer);

    void notifyObservers();
}
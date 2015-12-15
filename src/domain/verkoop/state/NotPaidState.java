package domain.verkoop.state;

import domain.verkoop.Verkoop;

public class NotPaidState implements State {

    private Verkoop verkoop;

    public NotPaidState(Verkoop v) {
        this.verkoop = v;
    }

    @Override
    public String getName() {
        return "IsNotPaid";
    }

    @Override
    public void pay() {
        verkoop.setCurrentState(new IsPaidState(verkoop));
    }

    @Override
    public void notPayed() {
        throw new IllegalArgumentException("De rekening is nog niet betaald");

    }

    @Override
    public void clear() {
        // TODO: is dit wel juist
        verkoop.getEntries().clear();
        verkoop.notifyObservers();
    }
}

package domain.verkoop.state;

import domain.verkoop.Verkoop;

public class IsPaidState implements State {

    private Verkoop verkoop;

    public IsPaidState(Verkoop v) {
        this.verkoop = v;
    }

    @Override
    public String getName() {
        return "Paid";

    }

    @Override
    public void pay() {
        throw new IllegalArgumentException("is already Paid");
    }

    @Override
    public void notPayed() {
        verkoop.setCurrentState(new NotPaidState(verkoop));
    }

    @Override
    public void clear() {
        throw new IllegalArgumentException("is already Paid");
    }


}

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
    public double pay(double payment) throws InsuffientPaymentException {
        if (payment > verkoop.getTotalcost()) {
            verkoop.setCurrentState(verkoop.getPaidState());
            return payment - verkoop.getTotalcost();
        } else {
            throw new InsuffientPaymentException("Payment too low", verkoop.getTotalcost() - payment);
        }
    }

    @Override
    public void notPayed() {
        throw new IllegalArgumentException("De rekening is nog niet betaald");

    }

    @Override
    public void clear() {
        verkoop.getEntries().clear();
        verkoop.notifyObservers();
    }

    @Override
    public void removeEntry(int index) {
        verkoop.getEntries().remove(index);
        verkoop.notifyObservers();
    }
}
package domain.verkoop.state;
/**
 * 
 * @author Larry & Annelore
 *
 */
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
    public double pay(double payment) {
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

    @Override
    public void removeEntry(int index) {
        throw new IllegalArgumentException("is already Paid");
    }
}
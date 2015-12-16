package domain.verkoop;

import domain.korting.Korting;
import domain.product.Product;
import domain.verkoop.state.InsuffientPaymentException;
import domain.verkoop.state.IsPaidState;
import domain.verkoop.state.NotPaidState;
import domain.verkoop.state.State;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Larry & Annelore
 *
 */
public class Verkoop implements Subject {

    public List<VerkoopEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<VerkoopEntry> entries) {
        this.entries = entries;
    }

    private List<VerkoopEntry> entries;
    private List<VerkoopObserver> observers;
    private State currentState;
    private IsPaidState ispaid;
    private NotPaidState notpaid;
    private Korting korting;

    public Verkoop() {
        entries = new ArrayList<VerkoopEntry>();
        observers = new ArrayList<VerkoopObserver>();
        ispaid = new IsPaidState(this);
        notpaid = new NotPaidState(this);
        currentState = this.getNotPaidState();
    }

    public void addProduct(Product p, int aantal) {
        if (p == null) {
            throw new IllegalArgumentException("geef geldig product in");
        }
        // TODO: vragen of double binding nodig of nuttig is
        entries.add(new VerkoopEntry(this, p, aantal));
        notifyObservers();
    }

    // TODO: move this to state
    public void removeProduct(Product p) {
        for (VerkoopEntry ve : entries) {
            if (ve.getProduct().equals(p)) {
                entries.remove(ve);
                break;
            }
        }
        notifyObservers();
    }

    public void removeEntry(int index) {
        currentState.removeEntry(index);
    }

    public void setAmountForEntry(int index, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        getEntries().get(index).setCount(amount);
        notifyObservers();
    }

    public void clear() {
        currentState.clear();
    }

    public double getTotalcostWithoutKorting() {
        double cost = 0;
        for (VerkoopEntry ve : entries) {
            cost += ve.getProduct().getPrice() * ve.getCount();
        }
        return cost;

    }

    public double getTotalcost() {
        if (this.getKorting() != null) {
            return this.getKorting().berekenKorting(this);
        }
        return this.getTotalcostWithoutKorting();
    }

    public List<VerkoopEntry> getProducts() {
        return this.entries;
    }


    @Override
    public void addObserver(VerkoopObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(VerkoopObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (VerkoopObserver o : observers)
            o.update(this);
    }

    public State getNotPaidState() {
        return notpaid;
    }

    public State getPaidState() {
        return ispaid;
    }

    public void pay(double v) throws InsuffientPaymentException {
        currentState.pay(v);
    }

    public void notPayed() {
        currentState.notPayed();
    }

    public void setKorting(Korting korting) {
        this.korting = korting;
        notifyObservers();
    }

    public Korting getKorting() {
        return this.korting;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(State status) {
        this.currentState = status;
    }

    public void deleteProductEntry(int rowToDelete) {
        this.currentState.removeEntry(rowToDelete);
    }
}

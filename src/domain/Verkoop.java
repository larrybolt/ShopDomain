package domain;
import java.util.ArrayList;
import java.util.List;

import domain.korting.Korting;
public class Verkoop implements Subject {
	
	private List<VerkoopEntry> entries;
	private List<Observer> observers;
	private State currentState;
	
	public Verkoop(){
		entries = new ArrayList<VerkoopEntry>();
		observers = new ArrayList<Observer>();
		currentState =  new NotPaidState();
	}

	public void addProduct(Product p, int aantal){
		if(p == null ){
			throw new IllegalArgumentException("geef geldig product in");
		}
		// TODO: vragen of double binding nodig of nuttig is
		entries.add(new VerkoopEntry(this, p, aantal));
		notifyObservers();
	}

	public void removeProduct(Product p){
		for (VerkoopEntry ve : entries){
			if (ve.getProduct().equals(p)){
				entries.remove(ve);
				break;
			}
		}
		notifyObservers();
	}

	public void clear(){
		entries.clear();
		notifyObservers();
	}

	public double getTotalcostWithoutKorting(){
		double cost = 0;
		for (VerkoopEntry ve : entries){
			cost += ve.getProduct().getPrice() * ve.getCount();
		}
		return cost;
	
	}
	public double getTotalcost(){
		if (this.getKorting() != null){
			return this.getKorting().berekenKorting(this);
		}
		return this.getTotalcostWithoutKorting();
	}

	public List<VerkoopEntry> getProducts(){
		return this.entries;
	}


	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers)
			o.update(this);
	}

	public void pay(double amound){
		if(this.currentState instanceof NotPaidState){
			currentState = currentState.pay(amound);
		}
	}
}

package domain;
import java.util.ArrayList;
import java.util.List;
public class Verkoop implements Subject {
	
	private List<VerkoopEntry> entries;
	private List<Observer> observers;
	
	public Verkoop(){
		entries = new ArrayList<VerkoopEntry>();
		observers = new ArrayList<Observer>();
	}

	public void addProduct(Product p, int aantal){
		if(p == null ){
			throw new IllegalArgumentException("geef geldig product in");
		}
		// @TODO: vragen of double binding nodig of nuttig is
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

	public double getTotalcost(){
		double cost = 0;
		for (VerkoopEntry ve : entries){
			cost += ve.getProduct().getPrice() * ve.getCount();
		}
		return cost;
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
}
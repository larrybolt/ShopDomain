package domain;
import java.util.ArrayList;
import java.util.List;
public class Verkoop implements Subject {
	
	private List<VerkoopEntry> entries;
	private List<Observer> observers;
	private Person customer;
	
	public Verkoop(Person customer){
		entries = new ArrayList<VerkoopEntry>();
		observers = new ArrayList<Observer>();
		this.setCustomer(customer);
	}

	public void addProduct(Product p, int aantal){
		if(p == null ){
			throw new IllegalArgumentException("geef geldig product in");
		}
		entries.add(new VerkoopEntry(this, p, aantal));
	}

	public void removeProduct(Product p){
		for (VerkoopEntry ve : entries){
			if (ve.getProduct().equals(p)){
				entries.remove(ve);
				break;
			}
		}
	}

	public void clear(){
		entries.clear();
	}

	public double getTotalcost(){
		double cost = 0;
		for (VerkoopEntry ve : entries){
			cost += ve.getProduct().getPrice() * ve.getCount();
		}
		return cost;
	}

	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
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
	public void notifyObserver() {
		for(Observer o : observers)
			o.update();
	}
}
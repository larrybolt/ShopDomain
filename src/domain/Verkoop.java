package domain;

import java.util.ArrayList;
import java.util.List;

public class Verkoop {
	
	private List<Product> producten;
	private Person customer;
	
	public Verkoop(Person customer){
		producten = new ArrayList<Product>();
		this.customer=customer;
	}
	public void addProduct(Product p, int aantal){
		if(p == null ){
			throw new IllegalArgumentException("geef geldig product in");
		}
		for(int i = 0; i<aantal;i++){
			producten.add(p);
		}
	}
	public void removeProduct(Product p){
		producten.remove(p);
	}
	public void clear(){
		producten.clear();
	}
	public double getTotalcost(){
		double cost = 0;
		for(Product p : producten){
			cost=cost+ p.getPrice();
		}
		return cost;
	}
}

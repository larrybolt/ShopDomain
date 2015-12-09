package domain;

import java.util.ArrayList;
import java.util.List;

import domain.korting.Korting;

public class VerkoopService {
	
	private Verkoop verkoop;
	
	public VerkoopService(){
		verkoop = new Verkoop();
	}
	public void addProduct(Product product, int aantal){
		verkoop.addProduct(product, aantal);
	}
	public ArrayList<VerkoopEntry> getVerkoopProducts(){
		return (ArrayList<VerkoopEntry>)verkoop.getProducts();
	}
	public void removeProduct(Product product){
		verkoop.removeProduct(product);
	}
	public void clearProducts(){
		verkoop.clear();
	}
	public double getTotalCost(){
		return verkoop.getTotalcost();
	}
	
	public void addObserver(Observer observer){
		verkoop.addObserver(observer);
	}
	
	public void removeObserver(Observer observer){
		verkoop.removeObserver(observer);
	}
	public void pay(double amount) {
		verkoop.pay(amount);
	}
	public void setKorting(Korting korting) {
		verkoop.setKorting(korting);
	}
	
}

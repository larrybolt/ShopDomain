package domain;

import java.util.ArrayList;

public class ShopFacade {
	private ProductService productService;
	private PersonService personService;
	private Verkoop verkoop;
	
	public ShopFacade(){
		this.productService = new ProductService();
		this.personService = new PersonService();
		this.verkoop = new Verkoop();
	}
	
	public void addProduct(int id, int aantal){
		Product product = productService.getProduct(id);
		if(product == null){
			throw new IllegalArgumentException("Er bestaat geen product met opgegeven id");
		}
		verkoop.addProduct(product, aantal);
	}
	
	public void removeProduct(int id){
		Product product = productService.getProduct(id);
		if(product == null){
			throw new IllegalArgumentException("Er bestaat geen product met opgegeven id");
		}
		verkoop.removeProduct(product);
	}

	public ArrayList<Product> getProducts(){
		return (ArrayList<Product>)productService.getProducts();
	}

	public ArrayList<VerkoopEntry> getVerkoopProducts(){
		return (ArrayList<VerkoopEntry>)verkoop.getProducts();
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
	
	
}
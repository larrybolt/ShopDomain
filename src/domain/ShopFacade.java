package domain;

import java.util.ArrayList;

import domain.korting.Korting;

public class ShopFacade {
	private ProductService productService;
	private PersonService personService;
	private Verkoop verkoop;
	private KortingService kortingService;
	
	public ShopFacade(){
		this.productService = new ProductService();
		this.personService = new PersonService();
		this.verkoop = new Verkoop();
		this.kortingService = new KortingService();
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
		return verkoop.getTotalcostWithoutKorting();
	}
	
	// observers
	public void addObserver(Observer observer){
		verkoop.addObserver(observer);
	}
	
	public void removeObserver(Observer observer){
		verkoop.removeObserver(observer);
	}
	
	// korting
	public void applyKorting(String kortingcode) {
		Korting korting = getKortingService().getKorting(kortingcode);
		if (korting != null){
			getVerkoop().setKorting(korting);
		}
		else {
			throw new IllegalArgumentException("No such korting found!");
		}
	}
	public void removeKorting(){
		getVerkoop().setKorting(null);
	}

	// getters
	public ProductService getProductService() {
		return productService;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public Verkoop getVerkoop() {
		return verkoop;
	}

	public KortingService getKortingService() {
		return kortingService;
	}

}
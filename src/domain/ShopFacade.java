package domain;

import java.util.ArrayList;
import java.util.List;

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
	//PersonService
	public Person getPerson(int id){
		return personService.getPerson(id);
	}
	public void addPerson(Person p){
		personService.addPerson(p);
	}
	public void deletePerson(int id){
		personService.deletePerson(id);
	}
	public void deletePerson(String id){
		personService.deletePerson(id);
	}
	public Person getPersonByEmail(String email){
		return personService.getPersonByEmail(email);
	}
	public Person authenticate(String email, String password){
		return personService.authenticate(email, password);
	}
	public List<Person> getPersons(){
		return personService.getPersons();
	}
	//ProductService
	
	public void addProductinDB(Product product){
		productService.addProduct(product);
	}
	public void deleteProductinDB(String id){
		productService.deleteProduct(id);
	}
	public Product getProduct(int id){
		return productService.getProduct(id);
	}
	public Product getProduct(String id){
		return productService.getProduct(id);
	}
	public List<Product> getProductsFromDB(){
		return productService.getProducts();
	}
	public List<Product> getProductsFromDBOrderByPrice(){
		return productService.getProductsOrderByPrice();
	}

	public void updateProducts(Product p) {
		 productService.updateProducts(p);
	}
}
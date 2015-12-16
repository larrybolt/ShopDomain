package domain;

import domain.korting.Korting;
import domain.person.Person;
import domain.person.PersonService;
import domain.product.Product;
import domain.product.ProductService;
import domain.verkoop.KortingService;
import domain.verkoop.VerkoopEntry;
import domain.verkoop.VerkoopObserver;
import domain.verkoop.VerkoopService;
import domain.verkoop.state.InsuffientPaymentException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ShopFacade {
    private ProductService productService;
    private PersonService personService;
    private VerkoopService verkoopService;
    private KortingService kortingService;

    public ShopFacade() {
        this.productService = new ProductService();
        this.personService = new PersonService();
        this.verkoopService = new VerkoopService();
        this.kortingService = new KortingService();
    }

    public ShopFacade(InputStream configFile) {
        this.productService = new ProductService(configFile);
        this.personService = new PersonService(configFile);
        this.verkoopService = new VerkoopService(configFile);
        this.kortingService = new KortingService(configFile);
    }

    public void addProduct(int id, int aantal) {
        if (aantal < 1) {
            throw new IllegalArgumentException("Please input a possitive amount.");
        }
        Product product = productService.getProduct(id);
        if (product == null) {
            throw new IllegalArgumentException("No product found with id");
        }
        verkoopService.addProduct(product, aantal);
    }

    public void updateEntryAmount(int index, int aantal) {
        getVerkoopService().setVerkoopEntryAmount(index, aantal);
    }

    public void removeEntry(int index) {
        getVerkoopService().removeVerkoopEntry(index);
    }

    public void removeProduct(int id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            throw new IllegalArgumentException("Er bestaat geen product met opgegeven id");
        }
        verkoopService.removeProduct(product);
    }

    public ArrayList<Product> getProducts() {
        return (ArrayList<Product>) productService.getProducts();
    }

    public ArrayList<VerkoopEntry> getVerkoopProducts() {
        return verkoopService.getVerkoopProducts();
    }


    public void clearProducts() {
        verkoopService.clearProducts();
    }

    public double getTotalCost() {
        return verkoopService.getTotalCost();
    }

    // observers
    public void addObserver(VerkoopObserver observer) {
        verkoopService.addObserver(observer);
    }

    public void removeObserver(VerkoopObserver observer) {
        verkoopService.removeObserver(observer);
    }

    //PersonService
    public Person getPerson(int id) {
        return personService.getPerson(id);
    }

    public void addPerson(Person p) {
        personService.addPerson(p);
    }

    public void deletePerson(int id) {
        personService.deletePerson(id);
    }

    public void deletePerson(String id) {
        personService.deletePerson(id);
    }

    public Person getPersonByEmail(String email) {
        return personService.getPersonByEmail(email);
    }

    public Person authenticate(String email, String password) {
        return personService.authenticate(email, password);
    }

    public List<Person> getPersons() {
        return personService.getPersons();
    }
    //ProductService

    // korting
    public void applyKorting(String kortingcode) {
        Korting korting = getKortingService().getKorting(kortingcode);
        if (korting != null) {
            verkoopService.setKorting(korting);
        } else {
            throw new IllegalArgumentException("No such korting found!");
        }
    }
    
    public ArrayList<Korting> getKortingen() {
    	return (ArrayList<Korting>)getKortingService().getKortings();
    }

    private KortingService getKortingService() {
        return this.kortingService;
    }

    public void deleteProductinDB(String id) {
        productService.deleteProduct(id);
    }

    // getters
    public Product getProduct(int id) {
        return productService.getProduct(id);
    }

    public Product getProduct(String id) {
        return productService.getProduct(id);
    }

    private VerkoopService getVerkoopService() {
        return verkoopService;
    }

    public List<Product> getProductsFromDBOrderByPrice() {
        return productService.getProductsOrderByPrice();
    }

    public void updateProducts(Product p) {
        productService.updateProducts(p);
    }

    public void pay(double amount) throws InsuffientPaymentException {
        verkoopService.pay(amount);
    }

    public void startNewSale() {
        verkoopService.startNewSale();
    }

    public void deleteProductEntry(int rowToDelete) {
        verkoopService.deleteProductEntry(rowToDelete);

    }
}

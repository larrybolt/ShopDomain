package domain.verkoop;

import db.verkoop.VerkoopRepository;
import db.verkoop.VerkoopRepositoryDB;
import domain.korting.Korting;
import domain.product.Product;
import domain.verkoop.state.InsuffientPaymentException;

import java.io.InputStream;
import java.util.ArrayList;

public class VerkoopService {

    private Verkoop verkoop;
    private VerkoopRepository verkoopRepository;

    public VerkoopService() {
        verkoop = new Verkoop();
    }

    public VerkoopService(InputStream configFile) {
        verkoop = new Verkoop();
        verkoopRepository = new VerkoopRepositoryDB(configFile);
    }

    public void addProduct(Product product, int aantal) {
        verkoop.addProduct(product, aantal);
    }

    public ArrayList<VerkoopEntry> getVerkoopProducts() {
        return (ArrayList<VerkoopEntry>) verkoop.getProducts();
    }

    public void setVerkoopEntryAmount(int index, int amount) {
        verkoop.setAmountForEntry(index, amount);
    }

    public void removeVerkoopEntry(int index) {
        verkoop.removeEntry(index);
    }

    public void removeProduct(Product product) {
        verkoop.removeProduct(product);
    }

    public void clearProducts() {
        verkoop.clear();
    }

    public double getTotalCost() {
        return verkoop.getTotalcost();
    }

    public void addObserver(VerkoopObserver observer) {
        verkoop.addObserver(observer);
    }

    public void removeObserver(VerkoopObserver observer) {
        verkoop.removeObserver(observer);
    }

    public void pay(double amount) throws InsuffientPaymentException {
        verkoop.pay(amount);
    }

    public void setKorting(Korting korting) {
        verkoop.setKorting(korting);
    }

    public void startNewSale() {
        verkoop = new Verkoop();
    }

    public void deleteProductEntry(int rowToDelete) {
        verkoop.deleteProductEntry(rowToDelete);

    }
}
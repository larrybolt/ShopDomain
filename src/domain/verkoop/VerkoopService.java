package domain.verkoop;

import domain.korting.Korting;
import domain.product.Product;

import java.util.ArrayList;

public class VerkoopService {

    private Verkoop verkoop;

    public VerkoopService() {
        verkoop = new Verkoop();
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

    public void pay(double amount) {
        verkoop.pay(amount);
    }

    public void setKorting(Korting korting) {
        verkoop.setKorting(korting);
    }

	public void startNewSale() {
		verkoop = new Verkoop();
	}
}
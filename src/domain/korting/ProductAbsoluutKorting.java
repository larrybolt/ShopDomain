package domain.korting;

import domain.product.Product;
import domain.verkoop.Verkoop;
import domain.verkoop.VerkoopEntry;

public class ProductAbsoluutKorting extends Korting {
	
	private Product product;

	public ProductAbsoluutKorting(String code, double amount, Product product) {
		super(code, amount);
		setProduct(product);
	}

	@Override
	public double berekenKorting(Verkoop verkoop) {
		boolean found = false;
		double totalPrice = 0;
		/* 
		 * TODO: Moeten we een korting op 1 product kunnen toepassen,
		 * of op elk product van een type
		 * of op meerdere producten
		 */
		for (VerkoopEntry ve : verkoop.getProducts()){
			if (!found && ve.getProduct().equals(product)){
				found = true;
				totalPrice -= this.getAmount();
			} 
			totalPrice += ve.getEntryPrice();
		}
		return totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	private void setProduct(Product product) {
		this.product = product;
	}

}

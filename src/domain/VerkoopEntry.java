package domain;

public class VerkoopEntry {
	private Verkoop verkoop;
	private Product product;
	private int count = 0;
	
	public VerkoopEntry() {
	}
	
	public VerkoopEntry(Verkoop verkoop, Product product, int count){
		setVerkoop(verkoop);
		setProduct(product);
		setCount(count);
	}

	public Verkoop getVerkoop() {
		return verkoop;
	}

	public void setVerkoop(Verkoop verkoop) {
		this.verkoop = verkoop;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
package domain.korting;

import domain.product.Product;
import domain.verkoop.Verkoop;
import domain.verkoop.VerkoopEntry;

public class ProductRelativeKorting extends Korting {

    private Product product;

    public ProductRelativeKorting(String code, double amount, Product product) {
        super(code, amount);
        setProduct(product);
    }

    @Override
    public double berekenKorting(Verkoop verkoop) {
        boolean found = false;
        double totalPrice = 0;
        for (VerkoopEntry ve : verkoop.getProducts()) {
            if (!found && ve.getProduct().equals(product)) {
                found = true;
                // apply korting on first product
                double basisPrijs = ve.getProduct().getPrice();
                totalPrice += basisPrijs - (basisPrijs * this.getAmount());

                // if there are more than one products (thus count is > 1)
                if (ve.getCount() > 1) {
                    // this implementation is the same as getEntryPrice() except for subtracting 1 entry
                    totalPrice += ve.getProduct().getPrice() * (ve.getCount() - 1);
                }
            } else {
                totalPrice += ve.getEntryPrice();
            }
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

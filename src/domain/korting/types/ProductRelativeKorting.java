package domain.korting.types;

import domain.korting.Korting;
import domain.verkoop.Verkoop;
import domain.verkoop.VerkoopEntry;

public class ProductRelativeKorting extends Korting {

    private int productid;

    public int getProductId() {
        return productid;
    }

    public void setProductId(int productid) {
        this.productid = productid;
    }

    public ProductRelativeKorting(String code, double amount, int productid) {
        this(code, new Double(amount), new Integer(productid));
    }

    public ProductRelativeKorting(String code, Double amount, Integer productid) {
        super(code, amount);
        setProductId(productid);
    }

    @Override
    public double berekenKorting(Verkoop verkoop) {
        boolean found = false;
        double totalPrice = 0;
        for (VerkoopEntry ve : verkoop.getProducts()) {
            if (!found && ve.getProduct().getId() == getProductId()) {
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
}
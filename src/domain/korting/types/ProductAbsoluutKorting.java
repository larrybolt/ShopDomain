package domain.korting.types;

import domain.korting.Korting;
import domain.verkoop.Verkoop;
import domain.verkoop.VerkoopEntry;
/**
 * 
 * @author Larry 
 *
 */
public class ProductAbsoluutKorting extends Korting {

    private int productid;

    public ProductAbsoluutKorting(String code, double amount, int productid) {
        this(code, new Double(amount), new Integer(productid));
    }

    public ProductAbsoluutKorting(String code, Double amount, Integer productid) {
        super(code, amount);
        setProductId(productid);
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
        for (VerkoopEntry ve : verkoop.getProducts()) {
            if (!found && ve.getProduct().getId() == getProductId()) {
                found = true;
                totalPrice -= this.getAmount();
            }
            totalPrice += ve.getEntryPrice();
        }
        return totalPrice;
    }

    public int getProductId() {
        return productid;
    }

    private void setProductId(int productid) {
        this.productid = productid;
    }

}

package domain.korting.types;
import discount.domain.HappyMondayCalculator;
import domain.korting.Korting;
import domain.verkoop.Verkoop;
/**
 * 
 * @author Larry & Annelore
 *
 */
public class HappyMondayKorting extends Korting{
	
	private int productid;
	
	public HappyMondayKorting(String code, double amount){
		this(code, new Double(amount));
	}
	public HappyMondayKorting(String code, Double amount){
		super(code, amount);
	}
	@Override
	public double berekenKorting(Verkoop verkoop) {
		double discount = new HappyMondayCalculator().getDiscountBecauseItIsASpecialDay(verkoop.getTotalcostWithoutKorting());
		return verkoop.getTotalcostWithoutKorting()-discount;
	}

}

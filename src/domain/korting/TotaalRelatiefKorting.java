package domain.korting;

import domain.Verkoop;

public class TotaalRelatiefKorting extends Korting {

	public TotaalRelatiefKorting(String code, double amount) {
		super(code, amount);
	}

	@Override
	public double berekenKorting(Verkoop verkoop) {
		return verkoop.getTotalcostWithoutKorting()-(verkoop.getTotalcostWithoutKorting()*this.getAmount());
	}
}
package domain.korting;

import domain.verkoop.Verkoop;

public class TotaalAbsoluutKorting extends Korting {
    public TotaalAbsoluutKorting(String code, double korting) {
        super(code, korting);
    }

    @Override
    public double berekenKorting(Verkoop verkoop) {
        return verkoop.getTotalcostWithoutKorting() - this.getAmount();
    }
}
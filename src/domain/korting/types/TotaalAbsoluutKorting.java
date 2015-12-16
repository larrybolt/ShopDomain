package domain.korting.types;

import domain.korting.Korting;
import domain.verkoop.Verkoop;

public class TotaalAbsoluutKorting extends Korting {
    public TotaalAbsoluutKorting(String code, double korting) {
        this(code, new Double(korting));
    }

    public TotaalAbsoluutKorting(String code, Double korting) {
        super(code, korting);
    }

    @Override
    public double berekenKorting(Verkoop verkoop) {
        return verkoop.getTotalcostWithoutKorting() - this.getAmount();
    }
}
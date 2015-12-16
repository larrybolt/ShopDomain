package domain.korting.types;

import domain.korting.Korting;
import domain.verkoop.Verkoop;

public class TotaalRelatiefKorting extends Korting {

    public TotaalRelatiefKorting(String code, double amount) {
        this(code, new Double(amount));
    }

    public TotaalRelatiefKorting(String code, Double amount) {
        super(code, amount);
    }

    @Override
    public double berekenKorting(Verkoop verkoop) {
        return verkoop.getTotalcostWithoutKorting() - (verkoop.getTotalcostWithoutKorting() * this.getAmount());
    }
}
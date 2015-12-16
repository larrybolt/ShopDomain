package domain.korting;

import domain.verkoop.Verkoop;

abstract public class Korting {
    private String code;
    private double amount;

    //private boolean kortingApplied = false;

    abstract public double berekenKorting(Verkoop verkoop);

    protected Korting(String code, double amount) {
        setCode(code);
        setAmount(amount);
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public double getAmount() {
        return amount;
    }

    private void setAmount(double amount) {
        this.amount = amount;
    }
}
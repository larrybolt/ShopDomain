package domain.korting;

import domain.Verkoop;

abstract public class Korting {
	private String code;
	private double amount;
	//private boolean kortingApplied = false;

	/*
	 * TODO: verifieren dat dit correct is
	 * we geven gans de verkoop door, zodat bv het toepassen van een korting op bv
	 * een vrouwelijke customer toegestaan is
	 * mogelijk zou het beter zijn hier een clone van verkoop door te krijgen,
	 * zodat een verkoop object niet door een korting kan worden aangepast
	 */
	abstract public double berekenKorting(Verkoop verkoop);

	protected Korting(String code, double amount){
		setCode(code);
		setAmount(amount);
	}

	public String getCode(){
		return code;
	}
	private void setCode(String code){
		this.code = code;
	}
	
	public double getAmount(){
		return amount;
	}
	private void setAmount(double amount){
		this.amount = amount;
	}

	/*
	public boolean isKortingApplied() {
		return kortingApplied;
	}

	public void setKortingApplied() {
		this.kortingApplied = true;
	}
	*/
}
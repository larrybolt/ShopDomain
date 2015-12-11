package domain.State;

import domain.Verkoop;

public class IsPaidState implements State {
	
	private Verkoop verkoop;
	
	public IsPaidState(Verkoop v){
		this.verkoop = v;
	}
	@Override
	public String getName() {
		return "Paid";
		
	}

	@Override
	public void pay() {
		throw new IllegalArgumentException("is already Paid");
		
	}

	@Override
	public void notPayed() {
		verkoop.setCurrentState(new NotPaidState(verkoop));;	
	}
	

}
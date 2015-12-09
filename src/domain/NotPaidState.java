package domain;

public class NotPaidState implements State {
	
	public State pay(double amound){
		return new IsPaidState();
	}
}

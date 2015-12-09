package domain;

public class NotPaidState implements State {
	
	public State pay(){
		return new IsPaidState();
	}
}

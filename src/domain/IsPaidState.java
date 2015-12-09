package domain;

public class IsPaidState implements State {

	@Override
	public State pay(double amound) {
		throw new IllegalArgumentException("amound is already paid");
	}

}

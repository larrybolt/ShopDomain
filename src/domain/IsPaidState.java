package domain;

public class IsPaidState implements State {

	@Override
	public State pay() {
		throw new IllegalArgumentException("amound is already paid");
	}

}

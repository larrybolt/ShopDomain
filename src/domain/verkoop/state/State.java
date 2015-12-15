package domain.verkoop.state;

public interface State {

    String getName();

    void pay();

    void notPayed();

    void clear();

	void removeEntry(int index);
}

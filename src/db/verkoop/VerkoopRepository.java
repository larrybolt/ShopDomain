package db.verkoop;

import java.util.List;

import domain.verkoop.Verkoop;

public interface VerkoopRepository {
	public Verkoop get(int id);
	public List<Verkoop> getAll();
	public void add(Verkoop verkoop);
	public void update(Verkoop verkoop);
	public void delete(int id);
	public int generateNewId();
}

package db.verkoop;

import domain.verkoop.Verkoop;

import java.util.List;

public interface VerkoopRepository {
    Verkoop get(int id);

    List<Verkoop> getAll();

    void add(Verkoop verkoop);

    void update(Verkoop verkoop);

    void delete(int id);

    int generateNewId();
}

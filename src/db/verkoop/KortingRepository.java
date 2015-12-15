package db.verkoop;

import domain.korting.Korting;

import java.util.List;

public interface KortingRepository {
    Korting get(String code);

    List<Korting> getAll();

    void add(Korting korting);

    void update(Korting korting);

    void delete(String code);
}
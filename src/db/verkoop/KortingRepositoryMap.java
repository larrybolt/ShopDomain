package db.verkoop;

import domain.korting.Korting;
import domain.korting.TotaalAbsoluutKorting;
import domain.korting.TotaalRelatiefKorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KortingRepositoryMap implements KortingRepository {
    private Map<String, Korting> kortingen = new HashMap<>();

    public KortingRepositoryMap() {
        this.add(new TotaalAbsoluutKorting("10", 10));
        this.add(new TotaalAbsoluutKorting("15", 15));
        this.add(new TotaalAbsoluutKorting("20", 20));

        this.add(new TotaalRelatiefKorting("10%", .10));
        this.add(new TotaalRelatiefKorting("15%", .15));
        this.add(new TotaalRelatiefKorting("20%", .20));
    }

    @Override
    public Korting get(String code) {
        return kortingen.get(code);
    }

    @Override
    public List<Korting> getAll() {
        return new ArrayList<Korting>(kortingen.values());
    }

    @Override
    public void add(Korting korting) {
        if (korting == null) {
            throw new IllegalArgumentException("No korting given");
        }
        if (kortingen.containsKey(korting.getCode())) {
            throw new IllegalArgumentException("Korting already added");
        }
        kortingen.put(korting.getCode(), korting);
    }

    @Override
    public void update(Korting korting) {
        if (korting == null) {
            throw new IllegalArgumentException("No korting given");
        }
        kortingen.put(korting.getCode(), korting);
    }

    @Override
    public void delete(String code) {
        kortingen.remove(code);
    }
}
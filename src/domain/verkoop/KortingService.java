package domain.verkoop;

import db.verkoop.KortingRepository;
import db.verkoop.KortingRepositoryDB;
import db.verkoop.KortingRepositoryMap;
import domain.korting.Korting;

import java.io.InputStream;
import java.util.List;
/**
 * 
 * @author Larry & Annelore
 *
 */
public class KortingService {
    private KortingRepository repository;

    public KortingService() {
        this.repository = new KortingRepositoryMap();
    }

    public KortingService(InputStream resourceAsStream) {
        // TODO: KortingRepositoryDB has to be written
        this.repository = new KortingRepositoryDB(resourceAsStream);
    }

    public Korting getKorting(String code) {
        return getKortingRepository().get(code);
    }

    public List<Korting> getKortings() {
        return getKortingRepository().getAll();
    }

    public void addKorting(Korting korting) {
        getKortingRepository().add(korting);
    }

    public void updateKortings(Korting korting) {
        getKortingRepository().update(korting);
    }

    public void deleteKorting(String code) {
        getKortingRepository().delete(code);
    }

    private KortingRepository getKortingRepository() {
        return repository;
    }
}
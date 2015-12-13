package db.verkoop;
import java.util.List;
import domain.korting.Korting;

public interface KortingRepository {
		public Korting get(String code);
		public List<Korting> getAll();
		public void add(Korting korting);
		public void update(Korting korting);
		public void delete(String code);
}
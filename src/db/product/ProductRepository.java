package db.product;

import java.util.List;
import domain.product.Product;

public interface ProductRepository {
		
		public Product get(int id);
		public List<Product> getAll();
		public List<Product> getAllOrderByPrice();
		public void add(Product person);
		public void update(Product person);
		public void delete(int id);
		public int generateNewId();
	
}
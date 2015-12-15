package db.product;

import domain.product.Product;

import java.util.List;

public interface ProductRepository {

    Product get(int id);

    List<Product> getAll();

    List<Product> getAllOrderByPrice();

    void add(Product person);

    void update(Product person);

    void delete(int id);

    int generateNewId();

}
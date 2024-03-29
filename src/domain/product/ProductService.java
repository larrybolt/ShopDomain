package domain.product;

import db.product.ProductRepository;
import db.product.ProductRepositoryDB;
import db.product.ProductRepositoryMap;

import java.io.InputStream;
import java.util.List;
/**
 * 
 * @author Larry & Annelore
 *
 */
public class ProductService {
    private ProductRepository ProductRepository;

    public ProductService() {
        this.ProductRepository = new ProductRepositoryMap();
    }

    public ProductService(InputStream resourceAsStream) {
        this.ProductRepository = new ProductRepositoryDB(resourceAsStream);
    }

    public Product getProduct(String id) {
        return getProduct(Integer.parseInt(id));
    }

    public Product getProduct(int id) {
        return getProductRepository().get(id);
    }

    public List<Product> getProducts() {
        return getProductRepository().getAll();
    }

    public List<Product> getProductsOrderByPrice() {
        return getProductRepository().getAllOrderByPrice();
    }

    public void addProduct(Product product) {
        product.setId(getProductRepository().generateNewId());
        getProductRepository().add(product);
    }

    public void updateProducts(Product product) {
        getProductRepository().update(product);
    }

    public void deleteProduct(String id) {
        deleteProduct(Integer.parseInt(id));
    }

    public void deleteProduct(int id) {
        getProductRepository().delete(id);
    }

    private ProductRepository getProductRepository() {
        return ProductRepository;
    }
}
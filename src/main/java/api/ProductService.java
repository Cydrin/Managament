package api;

import src.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Integer getCountProducts();
    Product getProductByName(String productName);
    boolean isProductOnWarehouse(String productName);
    boolean isProductExist(String productName);
    boolean isProductExist(Long id);
}

package service;

import api.ProductService;
import src.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    List<Product> listOfProducts;

    public ProductServiceImpl(List<Product> listOfProducts){
        this.listOfProducts = listOfProducts;
    }

    public List<Product> getAllProducts(){
        return listOfProducts;
    }

    public Integer getCountProducts(){
        Integer sum = 0;

        for(Product product : listOfProducts){
            sum++;
        }

        return sum;
    }

    public Product getProductByName(String productName){
        for(Product product : listOfProducts){
            if(product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }

    public boolean isProductOnWarehouse(String productName) {
        for(Product product : listOfProducts){
            if(product.getProductCount() > 0){
                return true;
            }
        }
        return false;
    }

    //Method overloading
    public boolean isProductExist(String productName) {
        for(Product product : listOfProducts){
            if(product.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }
    //Method overloading
    public boolean isProductExist(Long productId) {
        for(Product product : listOfProducts){
            if(product.getId().equals(productId)){
                return true;
            }
        }
        return false;
    }
}

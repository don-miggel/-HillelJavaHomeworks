package hw35.spring_security.service;

import hw35.spring_security.entity.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> getAllProds();
    Product getProdById(Long id);
    Product createProduct(Product product);
    String deleteProduct(Long id);
}

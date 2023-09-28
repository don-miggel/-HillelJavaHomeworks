package hw34.springdata.service;

import hw34.springdata.entity.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProdById(Long id);
    Set<Product> getProductsByName(String name);
}

package hw31.spring.proj.repo;

import hw31.spring.proj.entity.Product;

import java.util.List;

public interface ProductRepo {

    List<Product> getAllProducts();
    Product getProductById(Integer id);
}

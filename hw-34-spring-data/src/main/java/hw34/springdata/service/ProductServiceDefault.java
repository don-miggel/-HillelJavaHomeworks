package hw34.springdata.service;

import hw34.springdata.entity.Product;
import hw34.springdata.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductServiceDefault implements ProductService{

    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProdById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Product> getProductsByName(String name) {

        return productRepository.findByNameLike(name.trim());
    }
}

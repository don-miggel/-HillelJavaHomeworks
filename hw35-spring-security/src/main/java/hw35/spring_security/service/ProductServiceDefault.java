package hw35.spring_security.service;

import hw35.spring_security.entity.Product;
import hw35.spring_security.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceDefault implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProds() {
        return productRepository.findAll();
    }

    @Override
    public Product getProdById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String deleteProduct(Long id) {

       Product p = getProdById(id);
        if(p != null) {
            productRepository.deleteById(id);
            return "Product with id: " + id + " was successfully deleted! ";
        }

        return "Product with id: "+ id + " was not found !";

    }
}

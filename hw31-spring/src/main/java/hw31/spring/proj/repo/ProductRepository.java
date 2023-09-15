package hw31.spring.proj.repo;

import hw31.spring.proj.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements ProductRepo {

    private List<Product> products;

    public ProductRepository(List<Product> products){
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(Integer id) {

        for (Product prd : products){
            if(prd.getId().equals(id))
                return prd;
        }
        return null;
    }

}

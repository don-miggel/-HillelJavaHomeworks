package hw31.spring.proj.config;

import hw31.spring.proj.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ProductsConfig {

    @Bean
    public List<Product> products(){

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(399.0, "Iphone SE 2020", 1));
        productList.add(new Product(1299.0, "Imac 24",2));
        productList.add(new Product(999.0, "Macbook Air M1", 3));
        productList.add(new Product(2049.0, "Macbook Pro 13' Mid 2018 ", 4));
        productList.add(new Product(699.0, "Mac mini m1 ", 5));
        productList.add(new Product(599.0, "Mac mini m2 ", 6));
        productList.add(new Product(1199.0, "Macbook air m2 ", 7));
        productList.add(new Product(6999.0, "Mac Pro ", 8));
        productList.add(new Product(999.0, "Iphone 15 Pro ", 9));

        return productList;
    }

    @Bean
    public Map<Product, Integer> productsInCart(){
        return new HashMap<>();
    }
}

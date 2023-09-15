package hw31.spring.proj.cart;

import hw31.spring.proj.entity.Product;
import hw31.spring.proj.repo.ProductRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope(scopeName = "prototype")
public class CartImpl implements Cart {

    private ProductRepository productRepo;

    private Map<Product, Integer> productsInCart;

    public CartImpl(ProductRepository productRepo, Map<Product, Integer> productsInCart){
        this.productsInCart = productsInCart;
        this.productRepo = productRepo;
    }

    @Override
    public double calculateTotal() {
        double total = 0.0;
        if(productsInCart.size() > 0){
            for (Product product: productsInCart.keySet())
                total+=product.getPrice() * productsInCart.get(product);
        }
        return total;
    }

    @Override
    public void addProduct(Integer id) {
        Product product = productRepo.getProductById(id);
        if(productsInCart.containsKey(product)){
            int amount = productsInCart.get(product);
            productsInCart.remove(product);
            productsInCart.put(product, ++amount);
        }else
            productsInCart.put(product,1);
    }

    @Override
    public void removeProduct(Integer id) {
        Product product = productRepo.getProductById(id);
        productsInCart.remove(product);
    }

    public boolean isCartEmpty(){
        return productsInCart.isEmpty();
    }

    @Override
    public void displayProdsInCart() {


        System.out.println("Added products to cart: ");
        for (Product prd : productsInCart.keySet()){
            System.out.println("Product name:" + prd.getName()+", amount: "+productsInCart.get(prd)+", with price: "
                    +prd.getPrice() * productsInCart.get(prd));
        }
    }
}

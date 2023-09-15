package hw31.spring.proj.cart;

public interface Cart {

    double calculateTotal();
    void addProduct(Integer id);
    void removeProduct(Integer id);
    void displayProdsInCart();

}

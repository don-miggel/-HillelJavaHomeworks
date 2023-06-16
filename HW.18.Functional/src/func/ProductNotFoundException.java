package func;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String category){
        super("Product [category: "+ category +"] is not found!");
    }
}

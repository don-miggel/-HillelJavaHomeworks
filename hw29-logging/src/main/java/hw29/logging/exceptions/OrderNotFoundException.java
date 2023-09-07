package hw29.logging.exceptions;

public class OrderNotFoundException extends Exception{

    public OrderNotFoundException(int orderNum){
        super(String.format("Order with number %d was not found", orderNum));
    }
}

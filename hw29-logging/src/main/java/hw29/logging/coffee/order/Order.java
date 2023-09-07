package hw29.logging.coffee.order;

public class Order {

    private String name;
    private int orderNumber;

    public Order(String name, int id){
        this.name = name;
        this.orderNumber = id;
    }

    public String getName() {
        return name;
    }

    public int orderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return  orderNumber +" | " +name+"\n";
    }
}

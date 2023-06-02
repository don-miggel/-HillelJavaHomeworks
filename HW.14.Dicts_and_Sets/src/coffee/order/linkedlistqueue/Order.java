package coffee.order.linkedlistqueue;

import java.util.Objects;

public class Order {

    private final int orderNumber;
    private final String clientName;

    public Order(int orderNumber, String clientName) {
        this.orderNumber = orderNumber;
        this.clientName = clientName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber && Objects.equals(clientName, order.clientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, clientName);
    }

    @Override
    public String toString() {
        return orderNumber + " | " +
                clientName;

    }
}

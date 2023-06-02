package coffee.order;

import coffee.order.linkedlistqueue.LinkedListQueue;
import coffee.order.linkedlistqueue.Order;

public class CoffeeOrderBoard {

    private static int ordersCount;

    private final LinkedListQueue<Order> ordersQueue;

    public CoffeeOrderBoard() {
        ordersCount = 0;
        ordersQueue = new LinkedListQueue<>();
    }

    public void add(String clientName) {
        Order newOrder = new Order(++ordersCount, clientName);
        ordersQueue.enqueue(newOrder);
        System.out.println("New order " + ordersQueue.peek() + " was created");
    }

    public Order deliver() {
        return ordersQueue.remove();
    }

    public Order deliver(int orderNum) {
        Order ord = ordersQueue.find(orderNum);
        if (ord != null)
            return ordersQueue.remove(ord);
        return null;
    }

    public void draw() {
        System.out.println("Num | Name");
        System.out.println(ordersQueue);
    }
}

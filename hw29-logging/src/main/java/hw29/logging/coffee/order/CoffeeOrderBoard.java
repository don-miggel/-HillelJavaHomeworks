package hw29.logging.coffee.order;


import hw29.logging.exceptions.OrderNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CoffeeOrderBoard {

    private static final Logger LOGGER = LogManager.getLogger(CoffeeOrderBoard.class);

    private int orderCount;

    private final List<Order> orders;

    public CoffeeOrderBoard(){

        orderCount = 0;
        orders = new ArrayList<>();
    }

    public Order add(String clientName){

        Order order = new Order(clientName, ++orderCount);
        LOGGER.info("Client {} has made a new order with an order number {}", clientName, orderCount);
        orders.add(order);
        return orders.get(orders.size()-1);
    }

    public Order deliver(){
        if(orders.size() == 0){
            System.out.println("Sorry, there is no orders left !");
            return null;
        }
        Order lastOrder = orders.get(0);
        LOGGER.info("Order with a number {} was given to a client {}", lastOrder.orderNumber(), lastOrder.getName());
        orders.remove(0);
        return lastOrder;
    }

    public Order deliver(int orderNum) {
        try {
            Order chosenOrder =  getOrderByNum(orderNum);
            LOGGER.info("Order with a number {} was given to a client {}", chosenOrder.orderNumber(), chosenOrder.getName());
            orders.remove(chosenOrder);
            return chosenOrder;
        }catch (OrderNotFoundException e){
            LOGGER.error(e);
        }

        return null;


        /*
        if(chosenOrder != null) {
            LOGGER.info("Order with a number {} was given to a client {}", chosenOrder.orderNumber(), chosenOrder.getName());
            orders.remove(chosenOrder);
        }


        else {
   //         LOGGER.info("Order with a number {} does not exist", orderNum);
   //         System.out.println("There is no order with a number: " + orderNum + " !");
            throw new OrderNotFoundException(orderNum);
        }

         */

    }

    private Order getOrderByNum(int orderNum) throws OrderNotFoundException{
        Order chosenOrder =  orders.stream().filter(order -> order.orderNumber()== orderNum)
                .reduce(null, (acc, val)->val);
        if(chosenOrder == null)
            throw new OrderNotFoundException(orderNum);
        return chosenOrder;
    }

    public void draw(){
        LOGGER.info("Dispaying all orders");
        System.out.println(this);
    }

    @Override
    public String toString() {
        Stream<String> allOrders = orders.stream().map(Order::toString);
        return allOrders.reduce("", (acc, val)->acc+val);
    }
}

package my.restful.hw.service;

import my.restful.hw.model.Order;
import my.restful.hw.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService{

    private List<Order> orders;

    {
        orders = new ArrayList<>();
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public Order getOrderById(Integer id) {
        return  orders.stream()
                .filter(order -> order.getOrderIntId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order addOrder(Order order) {

        orders.add(order);
        System.out.println(orders);
        return order;
    }
}

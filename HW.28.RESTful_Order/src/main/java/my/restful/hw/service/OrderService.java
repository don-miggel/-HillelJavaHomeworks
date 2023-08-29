package my.restful.hw.service;

import my.restful.hw.model.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrders();
    public Order getOrderById(Integer id);
    public Order addOrder(Order order);


}

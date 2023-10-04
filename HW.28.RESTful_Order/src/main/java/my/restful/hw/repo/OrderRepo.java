package my.restful.hw.repo;

import my.restful.hw.model.Order;

import java.util.List;

public interface OrderRepo {

    public List<Order> getAllOrders();
    public Order getOrderById(Integer id);
    public Order addOrder(Order order);

}

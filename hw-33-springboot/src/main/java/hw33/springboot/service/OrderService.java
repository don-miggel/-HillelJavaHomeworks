package hw33.springboot.service;

import hw33.springboot.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order getOrderById(Long id);
    Order updateOrder(Long id, Order updOrder);
    String deleteOrder(Long id);

}

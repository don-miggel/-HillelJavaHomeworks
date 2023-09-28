package hw32.spring.webservlet.service;

import hw32.spring.webservlet.entity.Order;
import hw32.spring.webservlet.entity.Product;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order getOrderById(int id);

    List<Product> getAllProductsByOrderId(int orderId);
    String GetInfoByOrderId(int orderId);
}

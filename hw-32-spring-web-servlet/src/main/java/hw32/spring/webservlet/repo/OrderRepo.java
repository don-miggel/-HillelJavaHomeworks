package hw32.spring.webservlet.repo;

import hw32.spring.webservlet.entity.Order;
import hw32.spring.webservlet.entity.Product;

import java.util.List;

public interface OrderRepo {

    List<Order> getAllOrders();
    Order getOrderById(int id);
    Order addOrder(Order order);
    List<Product> getProductsByOrderId(int orderId);
    double getTotalSumByOrderId(int id);

}

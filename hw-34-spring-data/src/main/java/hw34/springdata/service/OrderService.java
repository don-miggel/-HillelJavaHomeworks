package hw34.springdata.service;

import hw34.springdata.entity.Order;
import hw34.springdata.entity.Product;

import java.util.List;
import java.util.Set;

public interface OrderService {

    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order getOrderById(Long id);
    Order updateOrder(Long id, Order updOrder);
    String deleteOrder(Long id);
    Set<Product> getAllProductsByOrderId(Long orderId);
    Set<Order> findByCostLessThan(Double cost);
    Set<Order> findByCostGreaterThan(Double cost);
    Set<Order> findByDate(int year, int month, int day);
    Set<Order> findByCostInterval(Double startCost, Double endCost);
    Set<Order> findByDateInterval(String startDate, String endDate);


}

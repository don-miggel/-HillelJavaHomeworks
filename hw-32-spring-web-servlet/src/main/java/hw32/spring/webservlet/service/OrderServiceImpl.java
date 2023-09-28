package hw32.spring.webservlet.service;

import hw32.spring.webservlet.entity.Order;
import hw32.spring.webservlet.entity.Product;
import hw32.spring.webservlet.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepo orderRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.getAllOrders();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepo.addOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepo.getOrderById(id);
    }

    @Override
    public List<Product> getAllProductsByOrderId(int orderId) {
        return orderRepo.getProductsByOrderId(orderId);
    }

    @Override
    public String GetInfoByOrderId(int orderId) {
        return String.format("Total sum of order with id: %d is %g", orderId, orderRepo.getTotalSumByOrderId(orderId));
    }
}

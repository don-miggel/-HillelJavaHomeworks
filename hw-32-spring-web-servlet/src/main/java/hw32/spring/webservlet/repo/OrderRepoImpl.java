package hw32.spring.webservlet.repo;

import hw32.spring.webservlet.entity.Order;
import hw32.spring.webservlet.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepoImpl implements OrderRepo{

    private List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public Order getOrderById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Order addOrder(Order order) {
        Order o  =new Order();
        o.setProducts(order.getProducts());
        orders.add(o);
        return orders.get(orders.size()-1);
    }

    @Override
    public List<Product> getProductsByOrderId(int orderId) {
        return orders.stream().filter(order -> order.getId()== orderId)
                .findFirst().map(Order::getProducts).orElse(null);
    }

    @Override
    public double getTotalSumByOrderId(int id) {
         return orders.stream().filter(order -> order.getId()== id)
                .findFirst().map(Order::getOrderTotalCost).orElse(0.0);

    }
}

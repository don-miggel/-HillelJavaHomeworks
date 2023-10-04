package my.restful.hw.repo;

import my.restful.hw.model.Order;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderRepoImpl implements OrderRepo{

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

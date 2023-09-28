package hw33.springboot.service;

import hw33.springboot.entity.Order;
import hw33.springboot.entity.Product;
import hw33.springboot.repo.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order newOrder) {
        for (Product prd : newOrder.getProducts())
            newOrder.addSum(prd);
        return orderRepository.save(newOrder);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order updateOrder(Long id, Order updOrder) {
        Order o = orderRepository.findById(id).orElse(null);
        if(o != null) {
            o.getProducts().clear();
            o.resetCost();
            for(Product prd : updOrder.getProducts()) {
                o.addProduct(prd);
                o.addSum(prd);
            }
            return orderRepository.saveAndFlush(o);
        }
        return o;
    }

    @Override
    public String deleteOrder(Long id) {

        Order o = getOrderById(id);
        if(o != null) {
            orderRepository.deleteById(id);
            return "Order with id: " + id + " was successfully deleted! ";
        }

        orderRepository.deleteById(id);
        return "Order with id: "+ id + " was not found !";

    }
}

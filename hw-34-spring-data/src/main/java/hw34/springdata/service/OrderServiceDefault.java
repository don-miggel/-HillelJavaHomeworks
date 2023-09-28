package hw34.springdata.service;

import hw34.springdata.entity.Order;
import hw34.springdata.entity.Product;
import hw34.springdata.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OrderServiceDefault implements OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order newOrder) {
        for (Product prd : newOrder.getProducts()) {
            if(prd != null)
                newOrder.addSum(prd);
        }
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
                if(prd != null) {
                    o.addProduct(prd);
                    o.addSum(prd);
                }
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

    @Override
    public Set<Product> getAllProductsByOrderId(Long orderId) {

        Order o  = getOrderById(orderId);
        if(o != null) {
           return o.getProducts();
        }
        return null;
    }

    @Override
    public Set<Order> findByCostLessThan(Double cost) {
        return orderRepository.findByCostLessThan(cost);
    }

    @Override
    public Set<Order> findByCostGreaterThan(Double cost) {
        return orderRepository.findByCostGreaterThan(cost);
    }

    @Override
    public Set<Order> findByDate(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);

        return orderRepository.findByDate(date);
    }

    @Override
    public Set<Order> findByCostInterval(Double startCost, Double endCost) {
        System.out.println(startCost+" "+ endCost);
        if(startCost <= endCost)
            return orderRepository.findByCostBetween(startCost, endCost);
        return null;
    }

    @Override
    public Set<Order> findByDateInterval(String startDate, String endDate) {
        String[] startDateSplit = startDate.split("-");
        String[] endDateSplit = endDate.split("-");
        LocalDate startDateParsed = LocalDate.of(Integer.parseInt(startDateSplit[0]),
                                            Integer.parseInt(startDateSplit[1]),
                                            Integer.parseInt(startDateSplit[2]));

        LocalDate endDateParsed = LocalDate.of(Integer.parseInt(endDateSplit[0]),
                Integer.parseInt(endDateSplit[1]),
                Integer.parseInt(endDateSplit[2]));

        return orderRepository.findByDateBetween(startDateParsed, endDateParsed);
    }
}

package hw33.springboot.controller;

import hw33.springboot.entity.Order;
import hw33.springboot.entity.Product;
import hw33.springboot.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Order addNewProduct(@RequestBody Order newOrder){
       for (Product prd : newOrder.getProducts())
           newOrder.addSum(prd);
        return orderRepository.save(newOrder);
    }

    @GetMapping("/{orderId}")
    public @ResponseBody Order getOrderById(@PathVariable("orderId") Long orderId) {

        return orderRepository.findById(orderId).orElseThrow(() ->
                new RuntimeException(" Order with id = " + orderId+" was not found"));
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrderById(@PathVariable("orderId") Long orderId){
        orderRepository.deleteById(orderId);
    }

    @PutMapping("/{orderId}")
    public @ResponseBody Order updateOrderById(@PathVariable("orderId") Long orderId, @RequestBody Order newOrder){
        Order o = orderRepository.findById(orderId).orElse(null);
        if(o != null) {
            o.getProducts().clear();
            o.resetCost();
            for(Product prd : newOrder.getProducts()) {
                o.addProduct(prd);
                o.addSum(prd);
            }
            return orderRepository.saveAndFlush(o);
        }
        return o;
    }
}

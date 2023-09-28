package hw33.springboot.controller;

import hw33.springboot.entity.Order;
import hw33.springboot.entity.Product;
import hw33.springboot.repo.OrderRepository;
import hw33.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public @ResponseBody Order addNewProduct(@RequestBody Order newOrder){
        return orderService.createOrder(newOrder);
    }

    @GetMapping("/{orderId}")
    public @ResponseBody Order getOrderById(@PathVariable("orderId") Long orderId) {

        return orderService.getOrderById(orderId);
    }

    @DeleteMapping("/{orderId}")
    public @ResponseBody String deleteOrderById(@PathVariable("orderId") Long orderId){
        return orderService.deleteOrder(orderId);
    }

    @PutMapping("/{orderId}")
    public @ResponseBody Order updateOrderById(@PathVariable("orderId") Long orderId, @RequestBody Order newOrder){
       return orderService.updateOrder(orderId, newOrder);
    }
}

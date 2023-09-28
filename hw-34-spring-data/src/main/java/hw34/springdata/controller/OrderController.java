package hw34.springdata.controller;

import hw34.springdata.entity.Order;
import hw34.springdata.entity.Product;
import hw34.springdata.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {


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

    @GetMapping("/{orderId}/products")
    public @ResponseBody Set<Product> updateOrderById(@PathVariable("orderId") Long orderId){
        return orderService.getAllProductsByOrderId(orderId);
    }

    @GetMapping("/less")
    public @ResponseBody Set<Order> findOrdersByCostLessThan(@RequestParam(value = "less") Double cost){
        return orderService.findByCostLessThan(cost);
    }

    @GetMapping("/more")
    public @ResponseBody Set<Order> findOrdersByCostGreaterThan(@RequestParam(value = "more") Double cost){
        return orderService.findByCostGreaterThan(cost);
    }

    @GetMapping("/date")
    public @ResponseBody Set<Order> findOrdersByDate(@RequestParam(value = "y") int year,
                                                     @RequestParam(value = "m") int month,
                                                     @RequestParam(value = "d") int day){
        return orderService.findByDate(year, month, day);
    }

    @GetMapping("/costrange")
    public @ResponseBody Set<Order> findOrdersByCostRange(@RequestParam(value = "start") Double startCost,
                                                     @RequestParam(value = "end") Double endCost
                                                     ){
        return orderService.findByCostInterval(startCost, endCost);
    }

    @GetMapping("/daterange")
    public @ResponseBody Set<Order> findOrdersByDateRange(@RequestParam(value = "start") String start,
                                                     @RequestParam(value = "end") String end
    ){
        return orderService.findByDateInterval(start, end);
    }



}

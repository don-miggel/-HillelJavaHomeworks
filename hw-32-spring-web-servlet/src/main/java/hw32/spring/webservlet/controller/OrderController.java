package hw32.spring.webservlet.controller;

import hw32.spring.webservlet.entity.Order;
import hw32.spring.webservlet.entity.Product;
import hw32.spring.webservlet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(produces = "application/json")
    public @ResponseBody ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{orderId}")
    public @ResponseBody ResponseEntity<Order> getOrderById(@PathVariable("orderId") Integer orderId){
        return new ResponseEntity<>(orderService.getOrderById(orderId), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Order> addOrder(@RequestBody Order order){

        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{orderId}/products")
    public @ResponseBody ResponseEntity<List<Product>> getAllProdsByOrderId(@PathVariable("orderId") Integer orderId){
        return new ResponseEntity<>(orderService.getAllProductsByOrderId(orderId), HttpStatus.OK);
    }

    @GetMapping(value = "/{orderId}/total")
    public @ResponseBody ResponseEntity<String> getTotalSumByOrderId(@PathVariable("orderId") Integer orderId){
        return new ResponseEntity<>(orderService.GetInfoByOrderId(orderId), HttpStatus.OK);
    }
}

package hw34.springdata.controller;

import hw34.springdata.entity.Product;
import hw34.springdata.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public @ResponseBody List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public @ResponseBody Product getProductById(@PathVariable("id") Long id){

        return productService.getProdById(id);
    }

    @GetMapping("/name")
    public @ResponseBody Set<Product> getProductsByName(@RequestParam("name") String name){

        return productService.getProductsByName(name);
    }




}

package hw35.spring_security.controller;

import hw35.spring_security.entity.Product;
import hw35.spring_security.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public @ResponseBody ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<Product>> getAllProducts(){

        return new ResponseEntity<>(productService.getAllProds(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Product> getProductById(@PathVariable("id") Long id){

        return new ResponseEntity<>(productService.getProdById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        String result = productService.deleteProduct(id);

        if(result.contains("not found".toLowerCase().trim()))
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

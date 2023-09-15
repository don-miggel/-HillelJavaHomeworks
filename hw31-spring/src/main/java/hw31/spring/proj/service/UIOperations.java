package hw31.spring.proj.service;

import hw31.spring.proj.entity.Product;

public interface UIOperations {

    int getUserChoice();
    void dispayAllProducts();
    Product getProductById(Integer id);
    void checkout();
    void performUserOperation();

}

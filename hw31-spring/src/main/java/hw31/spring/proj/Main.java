package hw31.spring.proj;

import hw31.spring.proj.cart.Cart;
import hw31.spring.proj.cart.CartImpl;
import hw31.spring.proj.service.ProductServiceDefault;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("hw31.spring.proj");
        ProductServiceDefault productServiceDefault = applicationContext.getBean(ProductServiceDefault.class);
        productServiceDefault.performUserOperation();

    }
}
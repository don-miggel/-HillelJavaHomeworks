package hw32.spring.webservlet.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {

    private static int countPrd = 0;

    private int id;
    private String name;
    private double cost;

    public Product(){
        id = ++countPrd;
    }


}

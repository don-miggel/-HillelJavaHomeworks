package hw32.spring.webservlet.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int orderCount = 0;

    private int id;
    private LocalDate date;
    private Double cost;

    private List<Product> products = new ArrayList<>();

    public Order(){
        id = ++orderCount;
        cost = 0.0;
        date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Double getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public  void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getOrderTotalCost() {
        double total=0;
        for(Product prd : products)
            total += prd.getCost();

        return total;
    }

    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", products='" + products + '\'' +
                ", cost=" + getOrderTotalCost() +
                '}';
    }
}

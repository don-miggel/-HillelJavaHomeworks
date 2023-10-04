package my.restful.hw.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private static int orderCount = 0;

    private String id;
    private LocalDate date;

    @JsonProperty
    private List<Product> products;


    {
        products = new ArrayList<>();
    }

    public Order(){

        this.id = "Ord" + ++orderCount;
        this.date = LocalDate.now();

    }

    public String getId() {
        return id;
    }

    public  void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getOrderIntId(){
        return Integer.parseInt(id.replace("Ord",""));
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Product> getProducts() {
        return products;
    }


    public double getOrderTotalCost() {
        double total=0;
        for(Product prd : products)
            total += prd.getCost();
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", products='" + products + '\'' +
                ", cost=" + getOrderTotalCost() +
                '}';
    }
}

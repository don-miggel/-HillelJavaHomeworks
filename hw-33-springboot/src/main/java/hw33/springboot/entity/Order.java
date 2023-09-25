package hw33.springboot.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Entity(name="order")
@Table(name = "tbl_orders")
@Setter
@Getter
@AllArgsConstructor
public class Order {

    @Id
    @Column(name="ord_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ord_date")
    private LocalDate date;
    private Double cost;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_products_orders",
            joinColumns = { @JoinColumn(name = "order_id", referencedColumnName = "ord_id")},
            inverseJoinColumns = { @JoinColumn(name = "prod_id", referencedColumnName = "prd_id") })

    private Set<Product> products = new HashSet<>();

    public Order(){
        cost = 0.0;
        date = LocalDate.now();
    }
    public  void addProduct(Product newProduct){
        products.add(newProduct);
        newProduct.getOrders().add(this);
    }

    public void resetCost(){
        cost = 0.0;
    }

    public void addSum(Product prd){
        if(prd != null && prd.getCost() > 0)
            cost += prd.getCost();
    }
}

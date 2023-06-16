package func;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Product {

    private final double price;
    private final String name;

    private boolean discountable;

    private final LocalDate dateCreation;

    public Product(double price, String name, int day, int month, int year){
        this.name = name;
        this.price = price;
        dateCreation = LocalDate.of(year, month, day);
    }

    public Product(double price, String name, int day, int month, int year, boolean discountable){
        this(price, name, day, month, year);
        this.discountable = discountable;
    }

    public Product(double price, String name, LocalDate creationDate){
        this.price = price;
        this.name = name;
        this.dateCreation = creationDate;

    }

    public String getName() {
        return name;
    }

    public String getProductCat(){
        int firstSpaceIdx = name.indexOf(' ');
        return name.substring(0,firstSpaceIdx+1);
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscountable() {
        return discountable;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", discountable=" + discountable +
                ", created at=" + dateCreation +
                '}';
    }
}

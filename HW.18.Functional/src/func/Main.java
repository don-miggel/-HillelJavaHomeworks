package func;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        Stream<Product> productStream = null;

        Product book1 = new Product(263.23, "Book Java Core Horstmann",25,12,2022, true);
        Product lamp1 = new Product(20.21, "Lamp IKEA", 24,4,2023,  true);
        Product book2 = new Product(70.21, "Book Complete Java reference Schildt", 27,12,2022,
                true);
        Product book3 = new Product(271.11, "Book Absolute Java Savitch", 27,4,2023);
        Product phone1 = new Product(499.00, "Phone Apple SE2", 29,12,2022);
        Product book4 = new Product(30.11, "Book SE 8 Deitel",1,5,2023);
        Product book5 = new Product(250.11, "Book Java Early objects Gaddis" ,3,5,2023,
                true);
        Product phone2 = new Product(400.00, "Phone Samsung Galaxy",10,5,2023);
        Product book6 = new Product(35.11, "Book OCP Java Exam",11,5,2023);



        // tasks 1.1 and 1.2
        System.out.println("-----------------tasks 1.1 and 1.2----------------");
        productStream=productStream= Stream.of(book1, book2, book3, book4, book5, lamp1, phone1, phone2, book6);
        List<Product> lstBooksMore250 = productStream
                .filter(product -> product.getPrice() > 250 && product.getName().contains("Book"))
                .collect(Collectors.toList());

        System.out.println(lstBooksMore250);

        // tasks 2.1 and 2.2
        System.out.println("-------------------tasks 2.1 and 2.2------------------");
        productStream= Stream.of(book1, book2, book3, book4, book5, lamp1, phone1, phone2,
                book6);
        getProdsByCat(productStream, "Book");

        // tasks 3.1, 3.2 and 3.3
        System.out.println("-------------------tasks 3.1,3.2 and 3.3------------------");
        productStream= Stream.of(book1, book2, book3, book4, book5, lamp1, phone1, phone2, book6);
        getCheapest(productStream, "Book");

        // tasks 4.1 and 4.2
        System.out.println("-------------------tasks 4.1 and 4.2------------------");
        productStream= Stream.of(book1, book2, book3, book4, book5, lamp1, phone1, phone2, book6);
        getThreeLatest(productStream);

        //tasks 5.1 and 5.2
        System.out.println("-------------------tasks 5.1 and 5.2------------------");
        productStream= Stream.of(book1, book2, book3, book4, book5, lamp1, phone1, phone2, book6);
        System.out.println("Total sum is: "+ calculateTotal(productStream, "Book"));

        //tasks 6.1** and 6.2**
        System.out.println("-------------------tasks 6.1 and 6.2------------------");
        productStream= Stream.of(book1, book2, book3, book4, book5, lamp1, phone1, phone2, book6);
        groupProducts(productStream);

    }

    public static void getProdsByCat(Stream<Product> stream, String category){
        List<Product> booksDisc = stream
                .filter(product -> product.getName().contains(category))
                .filter(Product::isDiscountable)
                .map(product -> new Product(product.getPrice() * 0.9, product.getName(), LocalDate.now()))
                .collect(Collectors.toList());
        System.out.println(booksDisc);
    }

    public static void getCheapest(Stream<Product> stream, String category) throws Exception {

        Optional<Product> cheapestBook = stream.
                filter(product -> product.getName().contains(category))
                .min((prd1, prd2) -> (int) (prd1.getPrice() - prd2.getPrice()));

        System.out.println(cheapestBook.orElseThrow(() ->new ProductNotFoundException(category)));
    }

    public static void getThreeLatest(Stream<Product> stream){

        List<Product> lst = stream
                .sorted((prd1, prd2) -> prd2.getDateCreation().compareTo(prd1.getDateCreation()))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(lst);
    }

    public static double calculateTotal(Stream<Product> stream, String category){

        return stream.
                filter(product -> product.getDateCreation().getYear() == LocalDate.now().getYear())
                .filter(product -> product.getName().contains(category))
                .filter(product -> product.getPrice() <= 75)
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
    }

    public static void groupProducts(Stream<Product> stream){
        Map<String, List<Product>> groupedProds = stream.collect(Collectors.groupingBy(Product::getProductCat));
        groupedProds.forEach(
                (category, products) ->{
                    System.out.println(category);
                    products.forEach(product -> System.out.printf("      %s%n", product));
                }
        );
    }


}

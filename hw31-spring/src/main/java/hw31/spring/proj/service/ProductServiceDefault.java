package hw31.spring.proj.service;

import hw31.spring.proj.cart.CartImpl;
import hw31.spring.proj.entity.Product;
import hw31.spring.proj.repo.ProductRepo;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductServiceDefault implements UIOperations{

    private ProductRepo productRepo;
    private CartImpl cart;

    public ProductServiceDefault(ProductRepo productRepo, CartImpl cart){

        this.cart = cart;
        this.productRepo = productRepo;
    }

    public void dispayAllProducts() {
        for(Product prd: productRepo.getAllProducts())
            System.out.println(prd);
    }


    public Product getProductById(Integer id) {
        return productRepo.getProductById(id);
    }

    @Override
    public void checkout() {
        System.out.println("Your order consists of the next items: ");
        cart.displayProdsInCart();
        System.out.println("Total price of all items: "+ cart.calculateTotal());
    }

    @Override
    public void performUserOperation() {
        int userInput, selectedId;
        Product product = null;
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        while (true){
            userInput = getUserChoice();
            switch (userInput){
                case 0:
                    System.out.println("App exit...");
                    System.exit(0);
                case 1:
                    System.out.println("Please, select a product id to add to cart: ");
                    selectedId = scInt.nextInt();
                    cart.addProduct(selectedId);
                    cart.displayProdsInCart();
                    System.out.println("Do you want to make another operation ? Choose Y to proceed or any other symbol to checkout");
                    String continueChoice = scString.nextLine();
                    if(continueChoice.toLowerCase().equals("y"))
                        cart.displayProdsInCart();
                    else {
                        checkout();
                        System.exit(0);
                    }
                    break;
                case 2:
                    System.out.println("Please, select a product id to remove from cart: ");
                    selectedId = scInt.nextInt();
                    cart.removeProduct(selectedId);
                    if(cart.isCartEmpty())
                        System.out.println("The cart is empty now...");
                    else
                        cart.displayProdsInCart();
                    break;
                case 3:
                    checkout();
                    System.exit(0);
                default:
                    System.out.println("Wrong menu item select! Please, try one more time");

            }

        }
    }

    private void continueShopping(Scanner scanner){
        System.out.println("Do you want to add another product ? Choose Y to add or any other symbol to checkout");
        String continueChoice = scanner.nextLine();
        if(continueChoice.equals("Y"))
            cart.displayProdsInCart();
        else {
            checkout();
            System.exit(0);
        }
    }

    @Override
    public int getUserChoice() {
        System.out.println("Available products: ");
        dispayAllProducts();
        System.out.println("----------------------------------");
        System.out.println("Please, choose an operation: ");
        System.out.println("1 - add a Product to cart");
        System.out.println("2 - remove a Product from cart");
        System.out.println("3 - Checkout");
        System.out.println("0 - exit");
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        return userChoice;
    }

}

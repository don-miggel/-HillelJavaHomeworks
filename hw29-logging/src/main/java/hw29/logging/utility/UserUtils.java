package hw29.logging.utility;

import hw29.logging.coffee.order.CoffeeOrderBoard;
import hw29.logging.coffee.order.Order;

import java.util.Scanner;

public interface UserUtils {

    void addOrder(String clientName);
    Order getNextOrder();
    Order getOrderByNum(int  num);

    void performUserOperation();

    default int displayUserChoices(){
        System.out.println("Please, choose an operation: ");
        System.out.println("1 - add a new Order");
        System.out.println("2 - get a current state of an order queue" );
        System.out.println("3 - get next order");
        System.out.println("4 - get order by number");
        System.out.println("0 - exit");
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        return userChoice;
    }
}

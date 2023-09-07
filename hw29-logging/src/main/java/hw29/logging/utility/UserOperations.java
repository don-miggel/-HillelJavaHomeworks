package hw29.logging.utility;

import hw29.logging.coffee.order.CoffeeOrderBoard;
import hw29.logging.coffee.order.Order;

import java.util.Scanner;

public class UserOperations implements UserUtils {

    private CoffeeOrderBoard coffeeOrderBoard;

    public UserOperations(CoffeeOrderBoard coffeeOrderBoard){
        this.coffeeOrderBoard = coffeeOrderBoard;
    }

   public void addOrder(String clientName){
       if(!clientName.isEmpty())
          coffeeOrderBoard.add(clientName);
    }

    public Order getNextOrder(){
        return coffeeOrderBoard.deliver();
    }

    public   Order getOrderByNum(int  num) {
     return coffeeOrderBoard.deliver(num);
    }

    public void performUserOperation(){
        int userInput;
        Order order = null;
        Scanner sc = new Scanner(System.in);
        while (true){
            userInput = displayUserChoices();
            switch (userInput){
                case 0:
                    System.out.println("App exit...");
                    System.exit(0);
                case 1:
                    sc = new Scanner(System.in);
                    System.out.println("Please, enter a client name: ");
                    String clientName = sc.nextLine();
                    addOrder(clientName);
                    coffeeOrderBoard.draw();
                    break;
                case 2:
                    coffeeOrderBoard.draw();
                    break;
                case 3:
                    order = coffeeOrderBoard.deliver();
                    if(order != null)
                        System.out.println(order);
                    break;
                case 4:

                    System.out.println("Please, enter a ready order number ");
                    int orderNum = sc.nextInt();
                    order  = coffeeOrderBoard.deliver(orderNum);
                    if(order != null)
                        System.out.println(order);
                    break;
                default:
                    System.out.println("You have entered a wrong menu item. Please, choose again !");

            }
        }
    }


}

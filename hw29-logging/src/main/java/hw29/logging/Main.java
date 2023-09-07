package hw29.logging;

import hw29.logging.coffee.order.CoffeeOrderBoard;
import hw29.logging.utility.UserOperations;
import hw29.logging.utility.UserUtils;


public class Main {
    public static void main(String[] args) {
        var coffeeOrderBoard = new CoffeeOrderBoard();

        UserUtils userUtils = new UserOperations(coffeeOrderBoard);
        userUtils.performUserOperation();
    }
}
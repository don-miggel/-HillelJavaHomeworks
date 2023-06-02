package coffee.order.linkedlistqueue;

import coffee.order.CoffeeOrderBoard;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Chris");
        coffeeOrderBoard.add("Nelly");
        coffeeOrderBoard.add("Jim");
        coffeeOrderBoard.add("Billy");
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver(3);
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();
        coffeeOrderBoard.add("Ted");
        coffeeOrderBoard.add("Paul");
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver(5);
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();
    }



}

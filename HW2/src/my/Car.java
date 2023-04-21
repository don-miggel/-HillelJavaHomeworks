package my;

public class Car {

    public void start(){
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startElectricity(){
        System.out.println("Start electricity");
    }

    private void startCommand(){
        System.out.println("Start command");
    }

    private void startFuelSystem(){
        System.out.println("Start fuel system");
    }

    public static void main(String[] args) {

        Car car = new Car();
        car.start();
    }

}

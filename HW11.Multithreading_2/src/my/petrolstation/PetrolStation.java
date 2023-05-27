package my.petrolstation;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PetrolStation {

    private double amount;
    private final Semaphore semaphore;

    public PetrolStation(double amount){
        semaphore = new Semaphore(3);
        this.amount = amount;
    }

    public void doRefuel(Car car, double amountToFuel) throws InterruptedException {

        Random rnd = new Random();
        int secondsToWait = rnd.nextInt(3, 10);

            try {
                    semaphore.acquire();
                    if (amount > 0 && amount > amountToFuel) {
                        amount -= amountToFuel;
                        System.out.println(car.getCarData() + " fuels with " + amountToFuel + " liters" + " There is " +
                                amount + " liters left" + ", tank fueling lasts for " + secondsToWait + " seconds");
                        Thread.sleep(secondsToWait * 1000L);
                    } else {
                        System.out.println("The tank is empty!");
                    }

            }catch (InterruptedException e){
                System.out.println(e);
            }finally{
                semaphore.release();
            }
    }

}

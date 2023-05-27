package my.petrolstation;

public class Car implements Runnable{

    private static int carCount =0;

    private Thread thread;
    private double amountToFuel;
    private int carId;
    private PetrolStation petrolStation;

    public Car(PetrolStation petrolStation, double amountToFuel){
        carCount++;
        carId = carCount;
        this.petrolStation = petrolStation;
        this.amountToFuel = amountToFuel;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            petrolStation.doRefuel(this, amountToFuel);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCarData(){
        return "Car#"+carId;
    }

    public void fuel(){
        thread.start();
    }
}

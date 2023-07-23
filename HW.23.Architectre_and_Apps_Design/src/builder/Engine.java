package builder;

public class Engine {
    private double volume;
    private FuelType fuelType;
    private int cylinderNum;
    private boolean started;


    public Engine(FuelType fuelType, double volume, int  cylinderNum){
        this.volume = volume;
        this.fuelType = fuelType;
        this.cylinderNum = cylinderNum;
        started = false;
    }

    public double getVolume() {
        return volume;
    }

    public FuelType getEngineType() {
        return fuelType;
    }

    public double getCylinderNumber() {
        return cylinderNum;
    }

    public boolean isStarted() {
        return started;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "volume: " + volume +
                ", fuel Type: " + fuelType +
                ", cylinder number: " + cylinderNum +
                ", was engine started: " + started +
                '}';
    }
}

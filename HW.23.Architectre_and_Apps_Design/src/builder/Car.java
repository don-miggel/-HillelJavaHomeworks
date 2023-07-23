package builder;

import java.util.Locale;

public class Car {
    private final String brand;
    private final String model;
    private final String vin;
    private final CarType carType;
    private final int seats;
    private String wheelProducer;
    private String carColor;
    private final int doors;
    private final Engine engine;
    private final Transmission transmission;
    private final CarBattery carBattery;

    private final GPSNavigator gpsNavigator;
    private double fuelLevel ;
    private double mileageLevel;

    private Car(CarBuilder carBuilder) {
        this.brand  =carBuilder.brand;
        this.vin = carBuilder.vin;
        this.model = carBuilder.model;
        this.carType = carBuilder.carType;
        this.seats = carBuilder.seats;
        this.carBattery = carBuilder.carBattery;
        this.doors = carBuilder.doors;
        this.engine = carBuilder.engine;
        this.transmission = carBuilder.transmission;
        this.gpsNavigator = carBuilder.gpsNavigator;
        fuelLevel = 0.0;
        mileageLevel = 0.0;
    }

    public CarType getCarType() {
        return carType;
    }

    public double getFuel() {
        return fuelLevel;
    }

    public void setFuel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }

    public String getBrand() {
        return brand;
    }

    public String getVin() {
        return vin;
    }

    public int getDoors() {
        return doors;
    }

    public String getModel() {
        return model;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getMileageLevel() {
        return mileageLevel;
    }

    public static CarBuilder launchBuild() {
        return new CarBuilder();
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin: "+ vin+
                ", brand: "+ brand+
                ", carType: " + carType +
                ", seats number: " + seats +
                ", doors number: " + doors +
                ", engine: " + engine +
                ", transmission: " + transmission +
                ", gpsNavigator: " + gpsNavigator +
                ", fuel level: " + fuelLevel +
                ", mileage level: " + mileageLevel +
                '}';
    }

    public static class CarBuilder implements Builder{

        private String brand;
        private String model;
        private String vin;

        private CarType carType;
        private  int seats;
        private String wheelProducer;
        private String carColor;
        private CarBattery carBattery;
        private  int doors;
        private Engine engine;
        private Transmission transmission;
        private  GPSNavigator gpsNavigator;


        public Builder setVin(String vin) {
            this.vin = vin;
            System.out.println("The car vin is: "+ vin);
            return  this;
        }


        public Builder setBrand(String brand) {
            this.brand = brand;
            System.out.println("The car brand is: "+ brand);
            return this;
        }


        public Builder setModel(String model) {
            this.model = model;
            return this;
        }


        public Builder setCarType(String carType) {
            this.carType = CarType.valueOf(carType.toUpperCase());
            System.out.println("The car type is: "+ this.carType);
            return this;
        }


        public Builder setSeats(int seats) {
            this.seats = seats;
            System.out.println("The car has "+ seats +" seats");
            return this;
        }


        public Builder setEngine(String fuelType, double volume, int cylinderNum) {
            this.engine = new Engine(FuelType.valueOf(fuelType.toUpperCase()), volume, cylinderNum);
            System.out.println("The car is provided with "+ this.engine);
            return this;

        }

        public Builder setTransmission(String transmissionType, int speedNumber) {
            this.transmission = new Transmission(TransmissionType.valueOf(transmissionType.toUpperCase()), speedNumber);
            System.out.println("The car is provided with "+ this.transmission);
            return this;
        }



        public Builder setGPSNavigator() {
            this.gpsNavigator = new GPSNavigator();
            System.out.println("The car current route is: "+ this.gpsNavigator.getRoute());
            return this;

        }


        public Builder setWheels(String wheelProducer) {
            this.wheelProducer = wheelProducer;
            System.out.println("The wheel producer: "+ this.wheelProducer);
            return this;

        }


        public Builder setCarBattery(String carBatteryType, int warrantyMonths, String brand) {
            this.carBattery = new CarBattery(CarBatteryType.valueOf(carBatteryType.toUpperCase()), brand, warrantyMonths);
            System.out.println("The car is provided with "+ this.carBattery);
            return this;
        }


        public Builder setDoors(int num) {
            this.doors = num;
            System.out.println("The car has "+ doors+" doors");
            return this;

        }


        public Builder setCarBody(String carColor) {
            this.carColor = carColor;
            System.out.println("The car is of "+carColor+" color");
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

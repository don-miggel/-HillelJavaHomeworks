package builder;

public interface Builder {


    Builder setVin(String vin);
    Builder setBrand(String brand);
    Builder setModel(String model);
    Builder setCarType(String carType);
    Builder setSeats(int seats);
    Builder setEngine(String fuelType, double volume, int cylinderNum);
    Builder setTransmission(String transmissionType, int speedNumber);

    Builder setCarBattery(String carBatteryType, int warrantyMonths, String brand);
    Builder setGPSNavigator();
    Builder setWheels(String wheelProducer);

    Builder setDoors(int num);
    Builder setCarBody(String color);
    Car build();


}

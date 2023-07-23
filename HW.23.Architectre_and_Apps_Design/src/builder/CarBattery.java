package builder;

public class CarBattery {

    private final CarBatteryType carBatteryType;
    private final int warrantyMonths;
    private final String brand;

    public CarBattery(CarBatteryType carBatteryType, String brand, int warrantyMonths){
        this.carBatteryType = carBatteryType;
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public CarBatteryType getCarBatteryType() {
        return carBatteryType;
    }

    public double getWarrantyMonths() {
        return warrantyMonths;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "CarBattery{" +
                "carBatteryType=" + carBatteryType +
                ", capacity=" + warrantyMonths +
                ", brand='" + brand + '\'' +
                '}';
    }
}

package my.petrolstation;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(150);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(petrolStation, 50));
        cars.add(new Car(petrolStation, 75));
        cars.add(new Car(petrolStation, 65));
        cars.add(new Car(petrolStation, 55));
        cars.add(new Car(petrolStation, 90));
        cars.add(new Car(petrolStation, 80));

        for (Car car: cars)
            car.fuel();
    }
}

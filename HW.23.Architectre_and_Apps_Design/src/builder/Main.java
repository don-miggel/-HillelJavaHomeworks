package builder;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------------VOLVO SELECTED SPECS INCLUDED------------");
        Car volvoXC = Car.launchBuild()
                .setBrand("Volvo")
                .setModel("XC40 B5")
                .setVin("V0111111")
                .setCarBody("light brown")
                .setDoors(5)
                .setGPSNavigator()
                .setSeats(5)
                .setCarType("CUV")
                .build();
        System.out.println(volvoXC);
        System.out.println("-------------SKODA ALL SPECS INCLUDED------------");
        Car skodaOctavia = Car.launchBuild()
                .setBrand("Skoda")
                .setModel("Octavia")
                .setCarBody("white")
                .setCarType("sedan")
                .setDoors(4)
                .setGPSNavigator()
                .setEngine("gasoline", 2.0, 4)
                .setSeats(4)
                .setVin("SO222222")
                .setCarBattery("LITHIUM_ION", 66, "Skoda")
                .setTransmission("automatic", 7)
                .setWheels("Pirelli")
                .build();
        System.out.println(skodaOctavia);

    }
}

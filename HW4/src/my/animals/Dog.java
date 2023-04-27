package my.animals;

public class Dog extends Animal {

    private static int dogCount;

    static {
        dogCount = 0;
    }

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static void getDogCount() {
        System.out.println("Total amount of dogs is: " + dogCount);
    }

    @Override
    public void swim(int obstacleLength) {
        if (obstacleLength < 1) {
            System.out.println("Obstacle length cannot be less than 1");
            return;
        }
        if (obstacleLength > 10) {
            System.out.println("Dog cannot swim more than 10 meters !");
            return;
        }
        System.out.println(getCurrentClass() + " " + getName() + " has swum " + obstacleLength + " meters !");

    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength > 500) {
            System.out.println("Dog cannot run more than 500 meters !");
            return;
        }
        System.out.println(getCurrentClass() + " " + getName() + " has run " + obstacleLength + " meters !");

    }

}



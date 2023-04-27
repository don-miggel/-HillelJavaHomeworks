package my.animals;

public class Cat extends Animal {

    private static int catCount;

    static {
        catCount = 0;
    }

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static void getCatCount() {
        System.out.println("Total amount of cats is: " + catCount);
    }

    @Override
    public void swim(int obstacleLength) {
        System.out.println("Cat cannot swim!");
    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength > 200) {
            System.out.println("Cat cannot run more than 200 meters !");
            return;
        }
        System.out.println(getCurrentClass() + " " + getName() + " has run " + obstacleLength + " meters !");
    }

}

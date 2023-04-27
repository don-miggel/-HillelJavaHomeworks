package my.animals;

public class Animal {

    private static int animalCount;
    private final String name;

    static {
        animalCount = 0;
    }

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static void getAnimalCount() {
        System.out.println("Total amount of animals is: " + animalCount);
    }

    protected void swim(int obstacleLength) {
        System.out.println("Animal swims...");
    }

    ;

    protected void run(int obstacleLength) {
        System.out.println("Animal runs...");
    }

    ;

    protected String getName() {
        return name;
    }

    public String getCurrentClass() {
        String className = getClass().getName();
        return className.substring(className.lastIndexOf('.') + 1);
    }

    @Override
    public String toString() {

        return getCurrentClass() + "{" +
                "name='" + name + '\'' +
                '}';
    }
}

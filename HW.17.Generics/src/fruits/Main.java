package fruits;

public class Main {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        System.out.println(orangeBox);

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple(), new Apple());
        System.out.println(appleBox);

        orangeBox.addFruit(new Orange());
        System.out.println(orangeBox);
        System.out.println(appleBox.compare(orangeBox));
        orangeBox.addFruit(new Orange());
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.getWeight());

        Box<Apple> anotherAppleBox = new Box<>();
        anotherAppleBox.addFruit(new Apple(), new Apple(), new Apple(), new Apple(), new Apple());
        System.out.println(anotherAppleBox);
        appleBox.merge(anotherAppleBox);
        System.out.println(anotherAppleBox);
        System.out.println(appleBox);


    }
}

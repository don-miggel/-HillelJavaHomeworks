package strategy;

public class Main {
    public static void main(String[] args) {
        SquareCalc squareCalc = new Triangle(1,1, 10, 30, 20,0);
        Context context = new Context(squareCalc);
        System.out.println("Area of square: "+  context.calculateSquare());
        context.setStrategy(new Square(1,1,1,5,1,1,5,7));
        System.out.println("Area of triangle: "+context.calculateSquare());
    }
}

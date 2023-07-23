package strategy;

public class Square implements SquareCalc{

    private final Point A;
    private final Point B;
    private final Point C;
    private final Point D;

    public Square(double a1, double a2, double b1, double b2, double c1, double c2, double d1, double d2){
        A = new Point(a1, a2);
        B = new Point(b1, b2);
        C = new Point(c1, c2);
        D = new Point(d1, d2);
    }

    @Override
    public double calculateSquare() {

        double semiPerimeter = getPerimeter() / 2;
        double area =  Math.sqrt(
                        (semiPerimeter - SquareCalc.getBetweenPointsDistance(A, B)) *
                        (semiPerimeter - SquareCalc.getBetweenPointsDistance(B, C)) *
                        (semiPerimeter - SquareCalc.getBetweenPointsDistance(C, D)) *
                        (semiPerimeter - SquareCalc.getBetweenPointsDistance(D, A))
        );
        return SquareCalc.roundArea(area);
    }

    @Override
    public double getPerimeter() {
        return SquareCalc.getBetweenPointsDistance(A, B) +
                SquareCalc.getBetweenPointsDistance(B, C) +
                SquareCalc.getBetweenPointsDistance(C, D) +
                SquareCalc.getBetweenPointsDistance(D, A);
    }
}

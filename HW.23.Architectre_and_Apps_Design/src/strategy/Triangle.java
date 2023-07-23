package strategy;

public class Triangle implements SquareCalc {

    private Point A;
    private Point B;
    private Point C;

    public Triangle(double a1, double a2, double b1, double b2, double c1, double c2){
        this.A = new Point(a1, a2);
        this.B = new Point(b1, b2);
        this.C = new Point(c1, c2);
    }


    @Override
    public double calculateSquare() {

        double halfPerimeter = getPerimeter() / 2;
        double oppositeA = SquareCalc.getBetweenPointsDistance(B, C);
        double oppositeB = SquareCalc.getBetweenPointsDistance(A, C);
        double oppositeC = SquareCalc.getBetweenPointsDistance(A, B);
        double area =  Math.sqrt(halfPerimeter * (halfPerimeter - oppositeA) * (halfPerimeter - oppositeB) *
                (halfPerimeter - oppositeC));
        return SquareCalc.roundArea(area);
    }

    @Override
    public double getPerimeter() {
        return SquareCalc.getBetweenPointsDistance(A, B) +
               SquareCalc.getBetweenPointsDistance(B, C) +
               SquareCalc.getBetweenPointsDistance(A, C);
    }
}

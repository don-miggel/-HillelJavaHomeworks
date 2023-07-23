package strategy;

public interface SquareCalc {
    double calculateSquare();
    double getPerimeter();

    static double getBetweenPointsDistance(Point A, Point B){

        return Math.sqrt(Math.pow((B.getX() - A.getX()), 2) + Math.pow((B.getY() - A.getY()), 2));
    }

    static double roundArea(double area){
        return (Math.round(area) * 100.0) / 100.0;
    }
}

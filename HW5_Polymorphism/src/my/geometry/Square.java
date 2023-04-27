package my.geometry;

public class Square implements Shape{

    private  Vertex A;
    private  Vertex B;
    private Vertex C;
    private  Vertex D;

    public Square(double a1, double a2, double b1, double b2, double c1, double c2, double d1, double d2){
        A = new Vertex(a1, a2);
        B = new Vertex(b1, b2);
        C = new Vertex(c1, c2);
        D = new Vertex(d1, d2);
    }

    public Vertex getA() {
        return A;
    }

    public void setA(double a1, double a2) {
       A.setCoordinate(a1, a2);
    }

    public Vertex getB() {
        return B;
    }

    public void setB(double b1, double b2) {
        B.setCoordinate(b1, b2);
    }

    public Vertex getC() {
        return C;
    }

    public void setC(double c1, double c2) {
        C.setCoordinate(c1, c2);
    }

    public Vertex getD() {
        return D;
    }

    public void setD(double d1, double d2) {
        D.setCoordinate(d1, d2);
    }

    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        double area =  Math.sqrt((semiPerimeter - getPointsDistance(A, B)) * (semiPerimeter - getPointsDistance(B, C)) *
                (semiPerimeter - getPointsDistance(C, D))* (semiPerimeter - getPointsDistance(D, A)));
        return roundArea(area);
    }

    @Override
    public double getPerimeter() {
        return getPointsDistance(A, B) + getPointsDistance(B, C) + getPointsDistance(C, D) + getPointsDistance(D, A);
    }
}

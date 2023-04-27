package my.geometry;

public class Triangle implements Shape {

    private Vertex A;
    private Vertex B;
    private Vertex C;

    public Triangle(double a1, double a2, double b1, double b2, double c1, double c2){

        this.A = new Vertex(a1, a2);
        this.B = new Vertex(b1, b2);
        this.C = new Vertex(c1, c2);
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

    @Override
    public double getArea() {

            double halfPerimeter = getPerimeter() / 2;
            double oppositeA = getPointsDistance(B, C);
            double oppositeB = getPointsDistance(A, C);
            double oppositeC = getPointsDistance(A, B);
            double area =  Math.sqrt(halfPerimeter * (halfPerimeter - oppositeA) * (halfPerimeter - oppositeB) *
                    (halfPerimeter - oppositeC));
            return roundArea(area);
    }

    public double getPerimeter() {
        return getPointsDistance(A, B) + getPointsDistance(B, C) +
                getPointsDistance(A, C);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }
}

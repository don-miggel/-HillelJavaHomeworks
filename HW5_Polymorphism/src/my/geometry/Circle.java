package my.geometry;

public class Circle implements Shape {

    private double radius;
    private Vertex point;

    public Circle(double radius, double x, double y) {
        this.radius = radius;
        point = new Vertex(x, y);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Vertex getPoint() {
        return point;
    }

    public void setPoint(double x, double y) {
        point.setCoordinate(x, y);
    }

    @Override
    public double getArea() {
        return roundArea(Math.PI * Math.pow(radius, 2));
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", point=" + point +
                '}';
    }
}

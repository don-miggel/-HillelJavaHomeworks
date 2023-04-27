package my.geometry;

public interface Shape {

    double getArea();
    double getPerimeter();

    // find distance between two points to find area and/or perimeter of the triangle
    default double getPointsDistance(Vertex A, Vertex B){

        return Math.sqrt(Math.pow((B.getX() - A.getX()), 2) + Math.pow((B.getY() - A.getY()), 2));
    }

    default double roundArea(double area){
        return (Math.round(area) * 100.0) / 100.0;
    }

}

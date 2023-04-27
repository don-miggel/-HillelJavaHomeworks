package my.geometry;

public class Main {

    public static void main(String[] args) {

        Shape circle1 = new Circle(4,5,5);
        System.out.println(circle1.getArea());

        Shape circle2 = new Circle(3.2, 3,2);
        System.out.println(circle2.getArea());

        Shape rect1 = new Square(1,2,5,2,1,5,5,5);
        Shape rect2 = new Square(1,2,3,2,1,4,3,4);
        System.out.println(rect1.getArea());
        System.out.println(rect2.getArea());

        Shape tr1 = new Triangle(5.5,2,2,2,4,3);
        Shape tr2 = new Triangle(13,-1,-9,3,-3,-9);
        System.out.println(tr1.getArea());
        System.out.println(tr2.getArea());

        Shape[] shapes = new Shape[6];
        shapes[0] = circle1;
        shapes[1] = rect1;
        shapes[2] = tr1;
        shapes[3] = circle2;
        shapes[4] = rect2;
        shapes[5] = tr2;
        double totalSquare = 0.0;
        for (Shape sc : shapes){
            totalSquare += sc.getArea();
        }
        System.out.println("Total square is: "+ totalSquare);

    }
}

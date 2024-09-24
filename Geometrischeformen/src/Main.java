import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        List<Integer> shapes = new ArrayList<>();

        Random random = new Random();

        int shape;
        for(int i = 0; i < 10; ++i) {

            shape = random.nextInt(3) + 1;

            shapes.add(shape);

            System.out.println(shapes);
        }



        for (int randomshape : shapes) {

            switch(randomshape) {
                case 1:
                    Square square = Square.random();

                    System.out.println("Square surface area: " + square.calculatesurfacearea());
                    System.out.println("Square circumference: " + square.calculatecircumference());
                    Drawshapes.drawSurface(square);

                    break;
                case 2:
                    Rectangle rectangle = Rectangle.random();

                    System.out.println("Rectangle surface area: " + rectangle.calculatesurfacearea());
                    System.out.println("Rectangle circumference: " + rectangle.calculatecircumference());
                    Drawshapes.drawSurface(rectangle);

                    break;
                case 3:
                    Triangle triangle = Triangle.random();

                    System.out.println("Triangle surface area: " + triangle.calculatesurfacearea());
                    System.out.println("Triangle circumference: " + triangle.calculatecircumference());
                    Drawshapes.drawSurface(triangle);
            }
        }
    }

}


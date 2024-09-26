//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
import java.util.Scanner;


public class Main {
    public Main() {
    }

    public static void main(String[] args) {
//        List<Integer> shapes = new ArrayList<>();
//
//        Random random = new Random();
//
//        int shape;
//        for(int i = 0; i < 10; ++i) {
//
//            shape = random.nextInt(3) + 1;
//
//            shapes.add(shape);
//
//            System.out.println(shapes);
//        }
//
//
//
//        for (int randomshape : shapes) {
        Scanner shapescanner = new Scanner(System.in);
        System.out.println("What shape do you want to calculate?");

            switch(shapescanner.nextLine().toLowerCase()) {
                case "square":

                    Square square = Square.size();

                    System.out.println("Square surface area: " + square.calculatesurfacearea());
                    System.out.println("Square circumference: " + square.calculatecircumference());
                    Drawshapes.drawSurface(square);

                    break;
                case "rectangle":
                    Rectangle rectangle = Rectangle.size();

                    System.out.println("Rectangle surface area: " + rectangle.calculatesurfacearea());
                    System.out.println("Rectangle circumference: " + rectangle.calculatecircumference());
                    Drawshapes.drawSurface(rectangle);

                    break;
                case "triangle":
                    Triangle triangle = Triangle.size();

                    System.out.println("Triangle surface area: " + triangle.calculatesurfacearea());
                    System.out.println("Triangle circumference: " + triangle.calculatecircumference());
                    Drawshapes.drawSurface(triangle);
            }
        }
    }




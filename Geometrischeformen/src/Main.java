//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        // Main.dme();
        System.out.println(Square.random());
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
//        for (int randomshape : shapes) {
//
//            switch(randomshape) {
//                case 1:
//                    Surface square = Square.random();
//
//                    System.out.println("Square surface area: " + square.calculatesurfacearea());
//                    System.out.println("Square circumference: " + square.calculatecircumference());
//                    break;
//                case 2:
//                    int rectanglelength = (int)(Math.random() * 10.0) + 1;
//
//                    int rectanglewidth = (int)(Math.random() * 10.0) + 1;
//
//                    Surface rectangle = new Rectangle(rectanglelength, rectanglewidth);
//
//                    System.out.println("Rectangle surface area: " + rectangle.calculatesurfacearea());
//                    System.out.println("Rectangle circumference: " + rectangle.calculatecircumference());
//                    break;
//                case 3:
//                    int trianglebaselength = (int)(Math.random() * 10.0) + 1;
//
//                    int triangleleftlength = (int)(Math.random() * 10.0) + 1;
//
//                    int trianglerightlength = (int)(Math.random() * 10.0) + 1;
//
//                    int trianglehight = (int)(Math.random() * 10.0) + 1;
//
//                    Surface triangle = new Triangle(trianglebaselength, triangleleftlength, trianglerightlength, trianglehight);
//                    System.out.println("Triangle surface area: " + triangle.calculatesurfacearea());
//                    System.out.println("Triangle circumference: " + triangle.calculatecircumference());
//            }
//        }
    }

    public static void dme() {
        Square square = Square.random();
        for (int i = 0; i < square.getLength(); i++) {
            System.out.print("-");
        }
        System.out.println("");
        for (int i = 0; i < square.getLength(); i++) {
            System.out.print("|");
            for (int j = 0; j < square.getLength(); j++) {
                System.out.print(" ");
            }
            System.out.print("|\n");

        }
        for (int i = 0; i < square.getLength(); i++) {
            System.out.print("-");
        }
    }

}


public class Drawshapes {


    public Drawshapes() {

    }

    public static void drawSurface(Surface surface) {

        switch(surface) {
            case Square s -> drawSquare(s);
            case Rectangle r -> drawRectangle(r);
            case Triangle t -> drawTriangle(t);


            default -> throw new IllegalStateException("Unexpected value: " + surface);
        }

    }

   private static void drawSquare(Square square) {

        for (int i = 0; i < square.getLength(); i++) {
           for (int j = 0; j < square.getLength(); j++) {
               System.out.print("* ");
           }
           System.out.println();
        }
    }

   private static void drawRectangle(Rectangle rectangle) {

        for (int i = 0; i < rectangle.getLength(); i++) {
           for (int j = 0; j < rectangle.getWidth(); j++) {
                System.out.print("* ");
           }
           System.out.println();
       }
   }
    private static void drawTriangle(Triangle triangle) {

        for (int i = 0; i < triangle.getHight(); i++) {
            for (int j = 0; j <= i; j++) {
               System.out.print("* ");
           }
            System.out.println();
       }
   }
}





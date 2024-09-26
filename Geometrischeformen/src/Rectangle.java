import java.util.Scanner;

public class Rectangle extends Surface {
    private final int length;
    private final int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        this.name = "Rectangle";
    }

    public static Rectangle size() {
        Scanner rectanglescan = new Scanner(System.in);
        System.out.println("what is the side length of the rectangle?");
        int rectanglelength = rectanglescan.nextInt();

        System.out.println("what is the width of the rectangle?");
        int rectanglewidth = rectanglescan.nextInt();

        return new Rectangle(rectanglelength, rectanglewidth);
//        int rectanglelength = (int)(Math.random() * 10.0) + 1;
//        int rectanglewidth = (int)(Math.random() * 10.0) + 1;
//        return new Rectangle(rectanglelength, rectanglewidth);
    }

    public int calculatesurfacearea() {
        return this.length * this.width;
    }
    public int calculatecircumference() {
        return (this.length + this.width) * 2;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}

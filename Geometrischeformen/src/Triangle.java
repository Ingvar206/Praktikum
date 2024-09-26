import java.util.Scanner;

public class Triangle extends Surface{
    private final int baselength;
    private final int leftlength;
    private final int rightlength;
    private final int hight;

    public Triangle(int baselength, int leftlength, int rightlength, int hight) {
        this.baselength = baselength;
        this.leftlength = leftlength;
        this.rightlength = rightlength;
        this.hight = hight;
        this.name = "Triangle";
    }

    public static Triangle size() {
        Scanner trianglescan = new Scanner(System.in);
        System.out.println("what is the base length of the triangle?");
        int trianglebaselength = trianglescan.nextInt();

        System.out.println("what is the left side length of the triangle?");
        int triangleleftlength = trianglescan.nextInt();

        System.out.println("what is the right side length of the triangle?");
        int trianglerightlength = trianglescan.nextInt();


        int trianglehight = (int) Math.sqrt(trianglebaselength * trianglebaselength - ((trianglerightlength / 2) * (trianglerightlength / 2)));

        return new Triangle(trianglebaselength, triangleleftlength, trianglerightlength, trianglehight);
//        int trianglebaselength = (int)(Math.random() * 10.0) + 1;
//        int triangleleftlength = (int)(Math.random() * 10.0) + 1;
//        int trianglerightlength = (int)(Math.random() * 10.0) + 1;
//        int trianglehight = (int) Math.sqrt(trianglebaselength * trianglebaselength - ((trianglerightlength / 2) * (trianglerightlength / 2)));
//        return new Triangle(trianglebaselength, triangleleftlength, trianglerightlength, trianglehight);
    }
    public int calculatesurfacearea() {
        return (this.baselength * this.hight) / 2;
    }
    public int calculatecircumference() {
        return this.baselength + this.leftlength + this.rightlength;
    }

    public int getHight() {
        return hight;
    }
}

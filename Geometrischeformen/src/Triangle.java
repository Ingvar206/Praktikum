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

    public static Triangle random() {
        int trianglebaselength = (int)(Math.random() * 10.0) + 1;
        int triangleleftlength = (int)(Math.random() * 10.0) + 1;
        int trianglerightlength = (int)(Math.random() * 10.0) + 1;
        int trianglehight = (int) Math.sqrt(trianglebaselength * trianglebaselength - ((trianglerightlength / 2) * (trianglerightlength / 2)));
        return new Triangle(trianglebaselength, triangleleftlength, trianglerightlength, trianglehight);
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

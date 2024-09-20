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

    public int calculatesurfacearea() {
        return (this.baselength * this.hight) / 2;
    }
    public int calculatecircumference() {
        return this.baselength + this.leftlength + this.rightlength;
    }
}

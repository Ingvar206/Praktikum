public class Rectangle extends Surface {
    private final int length;
    private final int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        this.name = "Rectangle";
    }

    public int calculatesurfacearea() {
        return this.length * this.width;
    }
    public int calculatecircumference() {
        return (this.length + this.width) * 2;
    }
}

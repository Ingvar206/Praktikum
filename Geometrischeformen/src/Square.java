public class Square extends Surface {
    private final int length;

    public Square(int length) {
        this.length = length;
        this.name = "Square";
    }

    public static Square random() {
        int squarelength = (int)(Math.random() * 10.0) + 1;
        return new Square(squarelength);
    }

    public int calculatesurfacearea() {
        return this.length * this.length;
    }
    public int calculatecircumference() {
        return this.length * 4;
    }

    public int getLength() {
        return length;
    }
}


public abstract class Surface {
    String name = "";

    public Surface() {
    }

    public abstract int calculatesurfacearea();

    public abstract int calculatecircumference();

    //public abstract void drawToConsole();

    @Override
    public String toString() {
        return  name + " surface area: " + calculatesurfacearea()
                + ", circumference: " + calculatecircumference();
    }
}

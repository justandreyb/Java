package drawing;

public abstract class Shape {
    protected Point firstPoint;
    public Shape(double posX, double posY) {
        firstPoint = new Point(posX, posY);
    }
    public abstract void draw ();
}

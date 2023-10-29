package lesson5.abstractClass.actions.figure;

public class Rectangle extends Shape{
    private double x;
    private double y;

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double area() {
        return x * y;
    }
}

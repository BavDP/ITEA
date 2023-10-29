package lesson5.abstractClass.actions.figure;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return (double) Math.round(100 * radius * Math.pow(Math.PI, 2)) / 100;
    }
}

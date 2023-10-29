package lesson5.abstractClass.actions.figure;

public class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }


    @Override
    public double area() {
        return base * height * 0.5;
    }
}

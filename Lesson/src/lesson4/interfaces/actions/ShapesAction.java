package lesson4.interfaces.actions;

import MenuBuilder.AbstractAction;
import MenuBuilder.ConsoleMenuBuilder;
import lesson3.classes.actions.BookAction;

import java.util.Scanner;

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
class Rectangle implements Shape {
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double area() {
        return this.side1 * this.side2;
    }
}

public class ShapesAction extends AbstractAction {
    private Shape shape;

    class Circle extends AbstractAction {
        @Override
        public void doAction() {
            System.out.print("Radius: ");
            Scanner sc = new Scanner(System.in);
            double r = sc.nextDouble();
            shape = new lesson4.interfaces.actions.Circle(r);
            OutputAreaOfShape();
        }
    }

    class Rectangle extends AbstractAction {
        @Override
        public void doAction() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Side1: ");
            double side1 = sc.nextDouble();
            System.out.print("Side2: ");
            double side2 = sc.nextDouble();
            shape = new lesson4.interfaces.actions.Rectangle(side1, side2);
            OutputAreaOfShape();
        }
    }

    public void OutputAreaOfShape() {
        System.out.println("Area of shape is " + this.shape.area());
    }
    @Override
    public void doAction() {
        System.out.println("Shape Area");
        ConsoleMenuBuilder bookMenu = new ConsoleMenuBuilder("Shapes")
                .AddMenuItem("1", "Circle", new ShapesAction.Circle())
                .AddMenuItem("2", "Rectangle", new ShapesAction.Rectangle())
                .AddMenuItem("0", "Exit", null, true);
        bookMenu.Run();
    }
}

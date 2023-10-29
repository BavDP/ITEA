package lesson5.abstractClass.actions;

import MenuBuilder.AbstractAction;
import lesson5.abstractClass.actions.figure.Circle;
import lesson5.abstractClass.actions.figure.Rectangle;
import lesson5.abstractClass.actions.figure.Triangle;

public class FigureAction extends AbstractAction {
    @Override
    public void doAction() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(5, 6);
        Triangle triangle = new Triangle(10, 3);
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Triangle area: " + triangle.area());
    }
}

package lesson3.classes.actions;

import MenuBuilder.AbstractAction;

class Car {
    private String name;
    private int power;
    private int tankVolume;

    public Car(String name, int power, int tankVolume) {
        this.name = name;
        this.power = power;
        this.tankVolume = tankVolume;
    }

    public void start() {
        System.out.println("The car is started");
    }

    public void turnOff() {
        System.out.println("The car is turned off");
    }

    public void refuel(int amount) {
        System.out.println("The car is refueled by " + amount + " liters");
    }

    @Override
    public String toString() {
        return this.name + ", " + this.power + "(л.с.), " + this.tankVolume + "л.";
    }
}
public class CarAction extends AbstractAction {
    @Override
    public void doAction() {
        Car car = new Car("Renault", 91, 55);
        System.out.println(car);
        car.start();
        car.turnOff();
        car.refuel(40);
    }
}

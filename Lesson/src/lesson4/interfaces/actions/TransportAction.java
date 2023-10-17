package lesson4.interfaces.actions;

import MenuBuilder.AbstractAction;

abstract class CustomTransport {
    private int speed;

    public CustomTransport(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

}

class Car extends CustomTransport implements Transport {
    public Car(int speed) {
        super(speed);
    }

    public void start() {
        System.out.println("Car is started");
    }

    public void stop() {
        System.out.println("Car is stop");
    }
}

class Bicycle extends CustomTransport implements Transport {

    public Bicycle(int speed) {
        super(speed);
    }

    @Override
    public void start() {
        System.out.println("Bicycle is started");
    }

    @Override
    public void stop() {
        System.out.println("Bicycle is stop");
    }
}

public class TransportAction extends AbstractAction {

    private void activateTransport(Transport transport) {
        transport.start();
        System.out.println("Speed: " + transport.getSpeed());
        transport.stop();
    };
    @Override
    public void doAction() {
        this.activateTransport(new Bicycle(10));
        this.activateTransport(new Car(100));
    }
}

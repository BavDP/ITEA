package lesson2.forLoop.actions;

import MenuBuilder.AbstractAction;

public class FromAToZ extends AbstractAction {
    public void doAction() {
        for (int i = 65; i <= 90; i++) {
            System.out.println((char) i);
        }
    }
}

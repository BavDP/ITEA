package lesson2.forLoop.actions;

import MenuBuilder.AbstractAction;

public class From1To10Break5 extends AbstractAction {
    public void doAction() {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }
    }
}

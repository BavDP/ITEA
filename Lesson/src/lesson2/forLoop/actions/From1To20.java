package lesson2.forLoop.actions;

import MenuBuilder.AbstractAction;

public class From1To20 extends AbstractAction {
    public void doAction() {
        for (int i = 1; i <= 20; i++) {
            if (i%2 == 0 ) {
                System.out.println(i);
            }
        }
    };
}

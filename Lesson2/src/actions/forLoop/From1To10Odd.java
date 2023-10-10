package actions.forLoop;

import actions.AbstractAction;

public class From1To10Odd extends AbstractAction {
    public void doAction() {
        for (int i = 1; i <= 10; i++) {
            if (i%2 != 0) {
                System.out.println(i);
            }
        }
    }
}

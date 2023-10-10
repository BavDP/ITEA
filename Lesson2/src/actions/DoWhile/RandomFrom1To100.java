package actions.DoWhile;

import actions.AbstractAction;

import java.util.Random;

public class RandomFrom1To100 extends AbstractAction {
    public void doAction() {
        Random rnd = new Random();
        int num = 0;
        do {
            num = rnd.nextInt(100);
            System.out.print(num + " ");
        } while (num != 50);
        System.out.println("\n");
    }
}

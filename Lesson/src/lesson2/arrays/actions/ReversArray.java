package lesson2.arrays.actions;

import MenuBuilder.AbstractAction;

public class ReversArray extends AbstractAction {
    public void doAction() {
        String[] data = {"five", "three", "ten", "two"};
        for (int i = data.length - 1; i>=0; i--) {
            System.out.println(data[i]);
        }
    }
}

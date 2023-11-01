package lesson2.forEach.actions;

import MenuBuilder.AbstractAction;

public class OutColors extends AbstractAction {
    public void doAction() {
        String[] colors = {"red", "blue", "yellow"};
        for (String color: colors) {
            System.out.println(color);
        }
    }
}

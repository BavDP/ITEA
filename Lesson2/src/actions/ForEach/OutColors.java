package actions.ForEach;

import actions.AbstractAction;

import java.util.Scanner;

public class OutColors extends AbstractAction {
    public void doAction() {
        String[] colors = {"red", "blue", "yellow"};
        for (String color: colors) {
            System.out.println(color);
        }
    }
}

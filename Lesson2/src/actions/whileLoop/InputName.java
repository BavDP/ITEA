package actions.whileLoop;

import actions.AbstractAction;

import java.util.Scanner;

public class InputName extends AbstractAction {
    public void doAction() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Input your name: ");
            String name = sc.nextLine();
            if (name.equals("exit")) {
                break;
            }
            System.out.println("Hello " + name + "!");
        }
    }
}

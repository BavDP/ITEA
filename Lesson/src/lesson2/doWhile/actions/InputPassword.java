package lesson2.doWhile.actions;

import MenuBuilder.AbstractAction;

import java.util.Scanner;

public class InputPassword extends AbstractAction {
    private String psw = "qwerty";
    public void doAction() {
        String inputPsw = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Input password: ");
            inputPsw = sc.nextLine();
        } while(!inputPsw.equals(this.psw));
        System.out.println("OK!");
    }
}

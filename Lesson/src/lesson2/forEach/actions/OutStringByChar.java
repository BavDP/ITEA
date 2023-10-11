package lesson2.forEach.actions;

import MenuBuilder.AbstractAction;

import java.util.Scanner;

public class OutStringByChar extends AbstractAction {
    public void doAction() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input any string: ");
        String inputPsw = sc.nextLine();
        char[] inputStrChars = new char[inputPsw.length()];
        inputPsw.getChars(0, inputPsw.length(), inputStrChars, 0);
        for (char ch: inputStrChars) {
            System.out.println(ch);
        }
        int len = inputPsw.length();
        System.out.println("length = " + len);
    }
}

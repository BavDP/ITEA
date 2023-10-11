package lesson3.strings.actions;

import MenuBuilder.AbstractAction;

import java.util.Scanner;

public class ConcatStrings extends AbstractAction {
    public void doAction() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input string #1: ");
        String str1 = sc.nextLine();
        System.out.print("Input string #2: ");
        String str2 = sc.nextLine();
        StringBuilder builder = new StringBuilder(str1);
        String concat = builder.append(str2).toString();
        System.out.println("Result: " + concat);
    }
}